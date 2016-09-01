package aa.mine;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import aa.mine.domain.User;
import aa.mine.domain.UserRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class EhcacheTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CacheManager cacheManager;

	@Before
	public void before() {
		userRepository.save(new User("AAA", 10));
		userRepository.save(new User("BBB", 10));
		userRepository.save(new User("CCC", 10));
	}

	@Test
	public void test() throws Exception {

		User u1 = userRepository.findByName("AAA");
		System.out.println("第一次查询：" + u1.getAge());
		
		System.out.println(JSON.toJSONString(cacheManager.getCache("users")));

		User u2 = userRepository.findByName("AAA");
		System.out.println("第二次查询：" + u2.getAge());
		
		System.out.println(JSON.toJSONString(cacheManager.getCache("users")));
		
		u1.setAge(20);
		userRepository.save(u1);
		User u3 = userRepository.findByName("AAA");
		System.out.println("第三次查询：" + u3.getAge());
		
		System.out.println(JSON.toJSONString(cacheManager.getCache("users")));
				
	}

}
