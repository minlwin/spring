package com.jdc.hello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jdc.hello.config.dto.Message;
import com.jdc.hello.controller.interceptors.HelloInterceptor;

@Configuration
@EnableWebMvc
@ImportResource(locations = "/WEB-INF/controllers.xml")
@ComponentScan("com.jdc.hello.controller")
public class ServletConfig implements WebMvcConfigurer{
	
	@Autowired
	private HelloInterceptor helloInterceptor;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("hello");
	}
	
	@Bean
	public ViewResolver jspViewResolver() {
		return new InternalResourceViewResolver("/views/", ".jsp");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(helloInterceptor);
	}
	
	@Bean
	public RouterFunction<ServerResponse> routerDemo() {
		var message = new Message("Hello", "Hello from router function");
		return RouterFunctions.route()
				.GET("/router-demo", req -> ServerResponse
						.ok().contentType(MediaType.APPLICATION_XML).body(message)).build();
	}
}
