package aa.mine.templates;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	@RequestMapping("/")
	public String index(ModelMap map) {
		map.addAttribute("host", "http://mine.cn");
		return "Thymeleaf/index";
	}
}
