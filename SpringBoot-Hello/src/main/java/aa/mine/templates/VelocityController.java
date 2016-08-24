package aa.mine.templates;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Velocity")
public class VelocityController {

	//@RequestMapping("/velocity")
	@RequestMapping("")
	public String index(ModelMap map) {
		map.addAttribute("host", "http://mine.cn");
		return "Velocity/index";
	}
}
