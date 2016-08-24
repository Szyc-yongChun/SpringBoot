package aa.mine.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	/**
	 * The class is flagged as a @RestController, 
	 * meaning it’s ready for use by Spring MVC to handle web requests. 
	 * @RequestMapping maps / to the index() method. 
	 * invoked 调用
	 * When invoked from a browser or using curl on the command line, 
	 * the method returns pure text. 
	 * 
	 * That’s because @RestController combines @Controller and @ResponseBody, 
	 *       two annotations that results in web requests returning data rather than a view.
	 * 那是因为@RestController联合了@Controller and @ResponseBody两个注解导致返回的是数据而不是视图
	 */

	// todo http://localhost:8080/hello
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("Hello Spring-Boot");
		return "Hello Spring-Boot";
	}
}
