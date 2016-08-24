package aa.mine;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import aa.mine.Properties.blogConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ConfigTest {

	private static final Log log = LogFactory.getLog(ConfigTest.class);

	@Autowired
	private blogConfig blogConfig;


	@Test
	public void test() throws Exception {
		Assert.assertEquals("程序猿", blogConfig.getName());
		Assert.assertEquals("Spring Boot", blogConfig.getTitle());
		Assert.assertEquals("程序猿正在努力学习《Spring Boot》", blogConfig.getDesc());

		log.info("随机数测试输出：");
		log.info("随机字符串 : " + blogConfig.getValue());
		log.info("随机int : " + blogConfig.getNumber());
		log.info("随机long : " + blogConfig.getBignumber());
		log.info("随机10以下 : " + blogConfig.getRandom1());
		log.info("随机10-20 : " + blogConfig.getRandom2());

	}

}
