package com.jdc.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = {
	"com.jdc.demo.admin",
	"com.jdc.demo.member",
	"com.jdc.demo.utils"
})
@ImportResource("/application.xml")
public class AppConfig {

}
