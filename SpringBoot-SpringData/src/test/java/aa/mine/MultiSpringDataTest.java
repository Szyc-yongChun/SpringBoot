package aa.mine;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import aa.mine.Entity.Message;
import aa.mine.Entity.UserEntity;
import aa.mine.Repository.MessageRepository;
import aa.mine.Repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class MultiSpringDataTest {
	
	//private static Logger logger = Logger.getLogger(MultiSpringDataTest.class);
		
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MessageRepository messageRepository;

	@Test
	public void test() throws Exception {		
		
		userRepository.save(new UserEntity("aaa", 10));
		userRepository.save(new UserEntity("bbb", 20));
		userRepository.save(new UserEntity("ccc", 30));
		userRepository.save(new UserEntity("ddd", 40));
		userRepository.save(new UserEntity("eee", 50));

		Assert.assertEquals(5, userRepository.findAll().size());

		messageRepository.save(new Message("o1", "aaaaaaaaaa"));
		messageRepository.save(new Message("o2", "bbbbbbbbbb"));
		messageRepository.save(new Message("o3", "cccccccccc"));

		Assert.assertEquals(3, messageRepository.findAll().size());

		
	}
}
