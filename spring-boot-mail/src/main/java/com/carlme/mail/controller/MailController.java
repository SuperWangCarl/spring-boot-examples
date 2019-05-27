package com.carlme.mail.controller;

import com.carlme.mail.bean.Mail;
import com.carlme.mail.service.MailSendService;
import com.carlme.mail.service.SendMail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.Date;

/**
 * @ClassName: mailController
 * @Description: 邮件控制器
 * @Auther: SuperWang
 * @Date: 2018/8/16 15:28
 * @Vsersion: 0.0.1
 * @Copyright 中国电信集团系统集成有限责任公司
 */
@RestController
@RequestMapping("/mail")
@Slf4j
public class MailController {

	@Autowired
	SendMail sendMail;

	@Autowired
	MailSendService mailSendService;

	/**
	 * 使用 自定义的邮件发送方式
	 *
	 * @param mail
	 * @return
	 */
	@GetMapping("/send")
	public String sendMail(Mail mail) {
		//打印日志
		Date date = new Date();
		String dateStr = String.format("%tF %tT ", date, date);
		String logger = String.format("时间 : [ %s ],接受者为 : [ %s ],主题 : [ %s ],内容 : [ %s ]", dateStr, mail.getTo(), mail.getSubject(), mail.getText());
		log.info(logger);
		try {
			//方式一::
			sendMail.send(mail.getTo(), mail.getText(), mail.getSubject());
		} catch (Exception e) {
			e.printStackTrace();
			return "出异常了" + e.getMessage();
		}

		return "success";
	}

	/**
	 * 使用spring自定义的mail集成
	 *
	 * @return
	 * @throws MessagingException
	 */
	@GetMapping("/send/spring")
	public String contextLoads1() throws MessagingException {
		mailSendService.sendEmail("674949211@qq.com", "465端口", "成功");
		return "success";
	}

}
