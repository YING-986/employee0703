package com.firstdevelop.boot.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// 全局配置--跨域请求
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	/*
	 * 访问路径 请求来源 方法 允许携带 最大时间
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("Http://localhost:5173","null")
				.allowedMethods("GET","POST","PUT","OPTIONS","DELETE")
				.allowCredentials(true)
				.maxAge(3600);
		
	}

}
