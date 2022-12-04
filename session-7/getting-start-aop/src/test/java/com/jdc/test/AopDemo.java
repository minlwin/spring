package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.BusinessInterface;
import com.jdc.demo.OtherBean;

@SpringJUnitConfig(locations = "classpath:context.xml")
public class AopDemo {
	
	@Autowired
	private BusinessInterface businessBean;
	
	@Autowired
	private OtherBean otherBean;
	
	@Test
	void demo() {
		assertNotNull(businessBean);
		businessBean.doBusiness();
		
		otherBean.doJob();
	}

}
