package aa.mine.springboot;

import java.util.Arrays;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	
	public static void main(String[] args) {
		ApplicationContext ctx = (ApplicationContext) SpringApplication.run(Application.class,args);
		String[] beanNames = ((ListableBeanFactory) ctx).getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}
