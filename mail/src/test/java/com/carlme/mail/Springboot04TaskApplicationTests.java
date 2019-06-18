package com.carlme.mail;

import com.carlme.mail.bean.Mail;
import com.carlme.mail.service.MailSendService;
import com.carlme.mail.service.SendMail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04TaskApplicationTests {

	@Autowired
	JavaMailSenderImpl mailSender;

	//ssl 465认证
	@Autowired
	MailSendService mailSendService;

	@Autowired
	SendMail sendMail;

	/**
	 * 使用 自定义的邮件发送方式
	 */
	@Test
	public void sendMail() throws Exception {
		Mail mail = new Mail();
		mail.setTo("674949211@qq.com");
		mail.setSubject("主题");
		mail.setText("正文");
		//打印日志
		Date date = new Date();
		String dateStr = String.format("%tF %tT ", date, date);
		String logger = String.format("时间 : [ %s ],接受者为 : [ %s ],主题 : [ %s ],内容 : [ %s ]", dateStr, mail.getTo(), mail.getSubject(), mail.getText());
		sendMail.send(mail.getTo(), mail.getText(), mail.getSubject());
	}

	@Test
	public void contextLoads1() throws MessagingException {
		mailSendService.sendEmail("674949211@qq.com", "465端口", "成功");
	}

	@Test
	public void contextLoads() {
		SimpleMailMessage message = new SimpleMailMessage();
		//邮件设置
		message.setSubject("11通知-今晚开会222");
		message.setText("今晚7:30开会");


		message.setTo("674949211@qq.com");
		message.setFrom("15900714349@163.com");
		//message.setFrom("IT服务中心<superwangcarl@aliyun.com>");


		mailSender.send(message);
	}

	@Test
	public void test02() throws Exception {
		//1、创建一个复杂的消息邮件
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		//邮件设置
		helper.setSubject("通知-今晚开会");
		helper.setText("<b style='color:red'>今天 7:30 开会</b>", true);

		helper.setTo("17512080612@163.com");
		helper.setFrom("534096094@qq.com");
		//上传文件
		helper.addAttachment("1.jpg", new File("C:\\Users\\lfy\\Pictures\\Saved Pictures\\1.jpg"));
		helper.addAttachment("2.jpg", new File("C:\\Users\\lfy\\Pictures\\Saved Pictures\\2.jpg"));

		mailSender.send(mimeMessage);

	}

}
