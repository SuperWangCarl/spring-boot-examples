package com.carlme.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 配置三种
 */
@Configuration
public class RestConfig {

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}

	@Bean("urlConnection")
	public RestTemplate urlConnectionRestTemplate() {
		RestTemplate restTemplate = new RestTemplate(new SimpleClientHttpRequestFactory());
		return restTemplate;
	}

	@Bean("httpClient")
	public RestTemplate httpClientRestTemplate() {
		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		return restTemplate;
	}

	@Bean("OKHttp3")
	public RestTemplate OKHttp3RestTemplate() {
		RestTemplate restTemplate = new RestTemplate(new OkHttp3ClientHttpRequestFactory());
		return restTemplate;
	}
}