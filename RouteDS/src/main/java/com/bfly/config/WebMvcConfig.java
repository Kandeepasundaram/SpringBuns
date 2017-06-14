package com.bfly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.MappedInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private MultiTenancyInterceptor multiTenancyInterceptor;

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(multiTenancyInterceptor);
//	}
	
	public WebMvcConfig() {
		System.out.println("---------------------------------------------------------------");
		System.out.println("--------------------------WebMvcConfig-------------------------");
		System.out.println("---------------------------------------------------------------");
	}
	
	@Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
        return resolver;
    }
	
	@Bean
	public MappedInterceptor multiTenancyInterceptorX() {
	    return new MappedInterceptor(new String[]{"/**"}, multiTenancyInterceptor);
	}

}