package com.carlme.rest.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : jia
 * @Date : 2019/4/3
 * @Description : RestTemplate
 * @Version : 1.0
 */
@Configuration
@ConditionalOnClass(value = {RestTemplate.class, HttpClient.class})
public class RestTemplateConfig {

	@Value("${remote.maxTotalConnect:0}")
	private int maxTotalConnect; //连接池的最大连接数默认为0
	@Value("${remote.maxConnectPerRoute:200}")
	private int maxConnectPerRoute; //单个主机的最大连接数
	@Value("${remote.connectTimeout:2000}")
	private int connectTimeout; //连接超时默认2s
	@Value("${remote.readTimeout:30000}")
	private int readTimeout; //读取超时默认30s

	//创建HTTP客户端工厂
	private ClientHttpRequestFactory createFactory() throws Exception {
		if (this.maxTotalConnect <= 0) {
			SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
			factory.setConnectTimeout(this.connectTimeout);
			factory.setReadTimeout(this.readTimeout);
			return factory;
		}
		HttpClient httpClient = HttpClientBuilder.create().setMaxConnTotal(this.maxTotalConnect)
				.setMaxConnPerRoute(this.maxConnectPerRoute).build();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
		factory.setConnectTimeout(this.connectTimeout);
		factory.setReadTimeout(this.readTimeout);
		return factory;
	}

	//初始化RestTemplate,并加入spring的Bean工厂，由spring统一管理
	@Bean
	@ConditionalOnMissingBean(RestTemplate.class)
	public RestTemplate getRestTemplate() throws Exception {
		RestTemplate restTemplate = new RestTemplate(this.createFactory());
		List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();

		//重新设置StringHttpMessageConverter字符集为UTF-8，解决中文乱码问题
		converterList.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
		//加入FastJson转换器 根据使用情况进行操作，此段注释，默认使用jackson
		configureMessageConverters(converterList);
		//加入Error处理
		restTemplate.setErrorHandler(new DefaultResponseErrorHandler());

		return restTemplate;
	}

	@Primary
	@Bean(name = "remoteRestTemplate")
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue, SerializerFeature.QuoteFieldNames, SerializerFeature.DisableCircularReferenceDetect);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		MediaType[] mediaTypes = new MediaType[]{
				MediaType.APPLICATION_JSON,
				MediaType.APPLICATION_OCTET_STREAM,
				MediaType.TEXT_HTML,
				MediaType.TEXT_PLAIN,
				MediaType.TEXT_XML,
				MediaType.APPLICATION_STREAM_JSON,
				MediaType.APPLICATION_ATOM_XML,
				MediaType.APPLICATION_FORM_URLENCODED,
				MediaType.APPLICATION_JSON_UTF8,
				MediaType.APPLICATION_PDF,
		};
		List<MediaType> fastMediaTypes = Arrays.asList(mediaTypes);
		fastConverter.setSupportedMediaTypes(fastMediaTypes);
		converters.add(fastConverter);
	}


	private static class DefaultResponseErrorHandler implements ResponseErrorHandler {

		@Override
		public boolean hasError(ClientHttpResponse response) throws IOException {
			return response.getStatusCode().value() != HttpServletResponse.SC_OK;
		}

		@Override
		public void handleError(ClientHttpResponse response) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(response.getBody()));
			StringBuilder sb = new StringBuilder();
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			try {
				throw new Exception(sb.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
