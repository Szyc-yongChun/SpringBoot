package aa.mine;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

	/**
	 * 在Spring Boot的主类中加入@EnableScheduling注解，启用定时任务的配置
	 */
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class,args);
		
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}		
	}
}
