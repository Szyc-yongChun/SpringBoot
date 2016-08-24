package aa.mine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import aa.mine.service.userService;
import aa.mine.Application;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class JdbcTemplateTest {

	//注册的bean名称 userServiceImpl
	@Autowired
	@Qualifier("primaryUserServiceImpl")
	private userService userService;
	
	@Test
	public void create(){
		userService.create(6, "tom", 12);		
	}

	@Test
	public void deleteByName(){
		userService.deleteById(4);
	}

	@Test
	public void getAllUsers(){
		System.out.println(userService.getAllUsers());
	}
	
	@Test
	public void deleteAllUsers(){
		userService.deleteAllUsers();
	}
}
