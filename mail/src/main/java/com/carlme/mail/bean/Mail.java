package com.carlme.mail.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @ClassName: Mail
 * @Description: 邮件
 * @Auther: SuperWang
 * @Date: 2018/8/16 15:30
 * @Vsersion: 0.0.1
 * @Copyright 中国电信集团系统集成有限责任公司
 */
@Component
@Data
@ConfigurationProperties(prefix = "spring.mail")
public class Mail {

	/**
	 * 邮箱host
	 */
	private String host;
	/**
	 * 邮箱端口号
	 */
	private String port;
	/**
	 * 其他属性
	 */
	private Properties properties;
	/**
	 * 发件人的用户名
	 */
	private String userName;

	/**
	 * 发件人的邮件密码
	 */
	private String password;

	/**
	 * 发件人昵称
	 */
	private String selfUsername;

	/**
	 * 接受者
	 */
	private String to;
	/**
	 * 发送者
	 */
	private String from;
	/**
	 * 主题
	 */
	private String subject;
	/**
	 * 正文
	 */
	private String text;
}
