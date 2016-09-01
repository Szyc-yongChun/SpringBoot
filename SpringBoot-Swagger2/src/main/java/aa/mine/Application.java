package aa.mine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	//TODO http://localhost:8080/swagger-ui.html
	/**
	 * 在生产环境，不能提供API文档，最好使用拦截器做过滤
	 * @param args
	 */
	
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

}
