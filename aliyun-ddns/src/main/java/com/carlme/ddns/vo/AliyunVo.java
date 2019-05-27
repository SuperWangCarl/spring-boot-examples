package com.carlme.ddns.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: AliyunVo
 * @Description: 参数封装
 * @Auther: SuperWang
 * @Email: carlme@aliyun.com
 * @Date: 2019/4/16 08:52
 * @Vsersion: 0.0.1
 */
@ConfigurationProperties(prefix="aliyun-vo")
@Data
@Component
public class AliyunVo {

	private String regionId ;
	/**
	 * 认证id
	 */
	private String accessKeyId ;
	/**
	 * 认证密钥
	 */
	private String accessKeySecret ;
	/**
	 * 一级域名
	 */
	private String domain;
	/**
	 * 多个二级域名
	 */
	private List<String> rr;
	/**
	 * 获取当前公网ip的访问地址
	 */
	private String path ;

}
