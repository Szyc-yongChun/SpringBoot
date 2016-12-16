package aa.mine.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aa.mine.springboot.entity.Person;
import aa.mine.springboot.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService service;
	
	@RequestMapping("/{str}")
	public String Person(@PathVariable String str) {
		Person p = service.findPersonById(str);
		return "Hello,\t"+p+"\t!";
	}
	
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("\t\t****************************************\t\t\n");
		System.out.println("\t\t****************************************\t\t\n");
		System.out.println("\t\t****************************************\t\t\n");
		System.out.println("\t\t****************************************\t\t\n");
		return "Hello,timebusker\t!";
	}
}
