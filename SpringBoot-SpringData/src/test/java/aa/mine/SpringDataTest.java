package aa.mine;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import aa.mine.Entity.UserEntity;
import aa.mine.Repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class SpringDataTest {
	
	private static Logger logger = Logger.getLogger(SpringDataTest.class);
		
	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {		
		
		// 创建10条记录
		userRepository.save(new UserEntity("AAA", 10));
		userRepository.save(new UserEntity("BBB", 20));
		userRepository.save(new UserEntity("CCC", 30));
		userRepository.save(new UserEntity("DDD", 40));
		userRepository.save(new UserEntity("EEE", 50));
		userRepository.save(new UserEntity("FFF", 60));
		userRepository.save(new UserEntity("GGG", 70));
		userRepository.save(new UserEntity("HHH", 80));
		userRepository.save(new UserEntity("III", 90));
		userRepository.save(new UserEntity("JJJ", 100));

		// 测试findAll, 查询所有记录
		Assert.assertEquals(10, userRepository.findAll().size());
		
		List<UserEntity> lu = userRepository.findAll();
		logger.info(JSON.toJSONString(lu));

		// 测试findByName, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findByName("FFF").getAge().longValue());		
		UserEntity u = userRepository.findByName("AAA");
		logger.info(JSON.toJSONString(u));
		
		// 测试findUser, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findUser("FFF").getAge().longValue());
		
		
		
		// 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
		Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());

		// 测试删除姓名为AAA的User
		userRepository.delete(userRepository.findByName("AAA"));

		// 测试findAll, 查询所有记录, 验证上面的删除是否成功
		Assert.assertEquals(9, userRepository.findAll().size());

	}
}
