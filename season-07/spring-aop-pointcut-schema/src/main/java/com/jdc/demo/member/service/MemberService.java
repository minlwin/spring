package com.jdc.demo.member.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.jdc.demo.BeforeLoger;
import com.jdc.demo.Data;
import com.jdc.demo.HelloEnabled;

@Component
@Qualifier("member")
@BeforeLoger
public class MemberService implements HelloEnabled{

	@Override
	public void hello(String message) {
		System.out.println("Hello Member Service");
	}
	
	public void saveData(Data data) {
		System.out.println("Argument Type Annotation");
	}
}
