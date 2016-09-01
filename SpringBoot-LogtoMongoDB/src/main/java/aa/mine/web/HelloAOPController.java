package aa.mine.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloAOPController {

	@RequestMapping("/{str}")
	public String hello(@PathVariable String str) {
		return "Hello,"+str+"!";
	}
}
