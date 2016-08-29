package aa.mine;

import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aa.mine.Task.AsyncTask;
import aa.mine.Task.SyncTask;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class AysncTest {

	public final static Logger log = Logger.getLogger(AysncTest.class);

	@Autowired
	private SyncTask syncTask;

	@Autowired
	private AsyncTask asyncTask;

	@Test
	public void syncTaskTest() {
		System.out.println("\nAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n");
		long st = System.currentTimeMillis();
		syncTask.doTaskOne();
		syncTask.doTaskTwo();
		syncTask.doTaskThree();
		long end = System.currentTimeMillis();
		System.out.println("\nAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n");
		System.out.println("                          " + (end - st) + "\n\n");
	}

	@Test
	public void asyncTaskTest() {
		System.out.println("\nAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n");
		long st = System.currentTimeMillis();
		Future<Integer> Task1 = asyncTask.doTaskOne();
		Future<Integer> Task2 = asyncTask.doTaskTwo();
		Future<Integer> Task3 = asyncTask.doTaskThree();
		long end = System.currentTimeMillis();
		System.out.println("\nAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n");
		System.out.println("                          " + (end - st) + "\n\n");
		while (true) {
			if (Task1.isDone() && Task2.isDone() && Task3.isDone()) {
				try {
					System.out.println("\n线程运行实际时间："+Task1.get());
					System.out.println("线程运行实际时间："+Task2.get());
					System.out.println("线程运行实际时间："+Task3.get()+"\n");
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
		}
	}
}
