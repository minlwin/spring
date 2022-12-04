package com.jdc.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackages = {
		"com.jdc.demo",
		"com.jdc.test.aspectj"
})
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
