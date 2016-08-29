package aa.mine.ScheduleTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import aa.mine.Entity.UserEntity;
import aa.mine.Service.UserService;

@Component
public class UserScheduleTask {

	public final static Logger log = Logger.getLogger(UserScheduleTask.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	/**
	 * 基于byType类型自动装配
	 */
	@Autowired
	private UserService userservice;

	@Scheduled(fixedRate = 5000)
	private void outlogger() {
		log.info("\n\n" + dateFormat.format(new Date()) + "\n\n");
	}

	@Scheduled(fixedRate = 5000)
	private void adduser() {
		// 每个线程处理50条记录
		ExecutorService executorService = Executors
				.newFixedThreadPool(Double.valueOf(Math.ceil(1000 / 50.0)).intValue());
		List<Future<Boolean>> futures = new ArrayList<Future<Boolean>>(1000);

		for (int i = 0; i < 1000; i++) {
			UserEntity ue = new UserEntity();
			ue.setAge((int) Math.random() * 1000);
			ue.setName(getRandomString(6));
			Callable<Boolean> callable = createHandleForTask(ue);
			futures.add(executorService.submit(callable));
		}
		executorService.shutdown();

		// 查看任务执行结果
		int failCount = 0;
		for (Future<Boolean> future : futures) {
			try {
				Boolean res = future.get();
				if (res != null && false == res) {
					failCount++;
				}
			} catch (Exception e) {
				log.error("call back exception", e);
				failCount++;
			}
		}
		log.info("当前执行任务失败的数量："+failCount);
	}

	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	// 实现Callable
	private Callable<Boolean> createHandleForTask(final UserEntity ue) {
		return new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				try {
					userservice.saveUser(ue);
					return true;
				} catch (Throwable e) {
					log.error(e);
					return false;
				}
			}
		};
	}
}
