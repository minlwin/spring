package com.jdc.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AdditionalServiceAspect {

	@DeclareParents(value = "com.jdc.demo.MyService+", 
			defaultImpl = AdditionalServiceDefault.class)
	static AdditionalService additionalService;
}
