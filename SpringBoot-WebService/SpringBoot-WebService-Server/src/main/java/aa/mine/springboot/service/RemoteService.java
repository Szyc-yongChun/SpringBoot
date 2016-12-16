package aa.mine.springboot.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

@WebService
public class RemoteService {
	
	@Autowired
	static PersonService service;

	@WebMethod
	public static String findPersonById(String personId){
		return JSON.toJSONString(service.findPersonById(personId));
	}

	@WebMethod
	public static String savePerson(String person){
		return person;
	}

	@WebMethod
	public static String findAll(){
		return JSON.toJSONString(service.findAll());
	}

	@WebMethod
	public static String updatePerson(String person){
		return person;
	}
}
