package aa.mine.templates;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javassist.NotFoundException;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	@RequestMapping("/")
	public String index(ModelMap map) throws Exception{
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.addAttribute("host", "http://mine.cn");
		return "Thymeleaf/index";
	}
	
	 @RequestMapping("/json")
	    public String json() throws NotFoundException {
	        throw new NotFoundException("没有找到对应的页面");
	    }
}
