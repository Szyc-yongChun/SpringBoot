package aa.mine.Task;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 同步任务
 * 
 * @author Administrator
 *
 */
@Component
public class SyncTask {

	public final static Logger log = Logger.getLogger(SyncTask.class);

	public static Random random = new Random();

	public Integer doTaskOne() {
		log.info("\n开始做任务一。。。");
		int DoTime = random.nextInt(10000);
		try {
			Thread.sleep(DoTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("\n任务一完成。。。耗时："+DoTime);
		return DoTime;
	}
	
	public Integer doTaskTwo() {
		log.info("\n开始做任务二。。。");
		int DoTime = random.nextInt(10000);
		try {
			Thread.sleep(DoTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("\n任务二完成。。。耗时："+DoTime);
		return DoTime;
	}
	
	public Integer doTaskThree() {
		log.info("\n开始做任务三。。。");
		int DoTime = random.nextInt(10000);
		try {
			Thread.sleep(DoTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("\n任务三完成。。。耗时："+DoTime);
		return DoTime;
	}
}
