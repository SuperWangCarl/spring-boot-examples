package com.carlme.web.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description: 添加web配置
 *
 * @param:
 * @return:
 * @auther: SuperWang
 * @date: 2019/3/13 17:16
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 * 配置 可以跨域
	 *
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*")
				.allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
				.allowCredentials(true).maxAge(3600);
	}


	/**
	 * 配置视图映射器
	 * viewcontroller
	 *
	 * @param registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/").setViewName("login");
	}

	/**
	 * 配置拦截器
	 *
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//super.addInterceptors(registry);
		//静态资源；  *.css , *.js
		//SpringBoot已经做好了静态资源映射
		//registry.addInterceptor(new HandlerInterceptorDemo()).addPathPatterns("/**")
		//		.excludePathPatterns("/index.html", "/", "/user/login");
	}
	/**
	 * 配置静态资源访问
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//registry.addResourceHandler(staticAccessPath).addResourceLocations("file:"+uploadFolder);
		//绝对路径 不打jar包也可以访问
		//registry.addResourceHandler(staticAccessPath).addResourceLocations("file:"+ PathUtil.getProjectPath() + CommonConstant.PATH_UPLOAD_FOLDER);
	}
}
