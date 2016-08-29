package aa.mine;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aa.mine.Entity.Message;
import aa.mine.Repository.MessageRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class MongoDBTest {

	//可以不配日志信息便可打印日志
	private final static Logger log = Logger.getLogger(MongoDBTest.class);
	
	@Autowired
	private MessageRepository messageRepository;

	@Before
	public void setUp() {
		messageRepository.deleteAll();
	}

	@Test
	public void test() throws Exception {

		// 创建三个Message，并验证Message总数
		try {
			messageRepository.save(new Message(1L, "didi", "AAAAAAAAA"));
			messageRepository.save(new Message(2L, "mama", "BBBBBBBBB"));
			messageRepository.save(new Message(3L, "kaka", "CCCCCCCCC"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		log.info(messageRepository.findAll().size());

		// 删除一个Message，再验证Message总数
		Message u = messageRepository.findOne(1L);
		messageRepository.delete(u);
		log.info(messageRepository.findAll().size());
		
		// 删除一个Message，再验证Message总数
		u = messageRepository.findMessageByid(2L);
		messageRepository.delete(u);
		log.info(messageRepository.findAll().size());

	}
}
