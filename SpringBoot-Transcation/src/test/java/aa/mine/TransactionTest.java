package aa.mine;

import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import aa.mine.Entity.UserEntity;
import aa.mine.Repository.UserRepository;
import aa.mine.Service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class TransactionTest {
	
	/**
	 * 使用基于注解的事物管理，默认情况只需要在业务方法上加上注释 @Transctional
	 */
	
	private static Logger logger = Logger.getLogger(TransactionTest.class);
		
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 基于byType类型自动装配
	 */
	@Autowired
	private UserService userservice;

	@Test
	public void test1() throws Exception {		
		
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
	
	//在总的业务方法上添加事务管理
	@Test
	@Transactional
	public void test2() throws Exception {
		userservice.saveUser(new UserEntity("YYYY", 10000));
		userservice.saveUser(new UserEntity("YYYY", 9999));
		userservice.saveUser(new UserEntity("YYYY", 10000));
		throw new Exception();
	}
	
	//在小的业务方法上添加事务管理
	@Test
	public void test3() throws Exception {
		try {
			userservice.saveUserO(new UserEntity("AAAAAAAA", 10000));
			try {
				userservice.saveUserO(new UserEntity("BBBBBBBB", 9999));
			} catch (Exception e) {
				// TODO: handle exception
			}
			userservice.saveUserO(new UserEntity("CCCCCCCC", 10000));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
