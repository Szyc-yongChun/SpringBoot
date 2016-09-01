package aa.mine;

import java.io.File;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.commons.collections.map.HashedMap;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class JavaMailSenderTests {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private VelocityEngine velocityEngine;

	@Test
	public void sendSimpleMail() throws Exception {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("services@airkunming.com");
		message.setTo("timebusker@qq.com");
		message.setSubject("主题：简单邮件");
		message.setText("测试邮件内容");
		try {
			mailSender.send(message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Test
	public void sendAttachmentsMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("timebusker@qq.com");
		helper.setTo("1241564291@qq.com");
		helper.setSubject("主题：有附件");
		helper.setText("有附件的邮件");

		FileSystemResource file = new FileSystemResource(new File("mine.png"));
		helper.addAttachment("附件-1.jpg", file);
		helper.addAttachment("附件-2.jpg", file);

		mailSender.send(mimeMessage);
	}

	@Test
	public void sendInlineMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("timebusker@qq.com");
		helper.setTo("timebusker@qq.com");
		helper.setSubject("主题：嵌入静态资源");
		helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

		FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
		helper.addInline("weixin", file);

		mailSender.send(mimeMessage);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void sendTemplateMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("timebusker@qq.com");
		helper.setTo("12414291@qq.com");
		helper.setSubject("主题：模板邮件");

		Map<String, Object> model = new HashedMap();
		model.put("username", "didi");
		String text = VelocityEngineUtils.mergeTemplateIntoString(
				velocityEngine, "template.vm", "UTF-8", model);
		helper.setText(text, true);

		mailSender.send(mimeMessage);
	}

}
