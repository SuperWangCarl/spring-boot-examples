package com.huayu.mail.service;

import com.huayu.mail.bean.Mail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;
import java.util.Date;
import java.util.Properties;

/**
 * 自定义邮件的方式
 */
@Service
@Slf4j
public class SendMail implements Serializable {


	@Autowired
	Mail mail;

	Session session = null;

	@PostConstruct
	public void init() {
		Properties props = mail.getProperties();
		props.put("mail.smtp.host", mail.getHost());
		props.put("mail.smtp.port", mail.getPort());

		session = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mail.getUserName(), mail.getPassword());
			}
		});
	}

	/**
	 * @描述 发送邮件方法
	 * @参数 [environment, mailTo, content, model]
	 * @返回值 void
	 * @创建人 licf
	 * @创建时间 2017/11/9
	 * @修改人和其它信息
	 */
	//@Async
	public void send(String mailTo, String content, String subject) throws Exception {
		Message msg = new MimeMessage(session);
		String nick = mail.getSelfUsername();
		InternetAddress fromAddress = new InternetAddress(nick);

		// 设置发件人地址信息
		msg.setFrom(fromAddress);

		// 设置收件人地址信息
		String[] to = mailTo.split(",");
		for (int i = 0; i < to.length; i++) {
			InternetAddress toAddress = new InternetAddress(to[i]);
			msg.addRecipient(Message.RecipientType.TO, toAddress);
		}

		//设置邮件主题
		msg.setSubject(subject);
		// 邮件内容
		msg.setText(content);
		//发送时间
		msg.setSentDate(new Date());
		Transport.send(msg);
	}

}
