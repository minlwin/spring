package com.jdc.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.AppConfig;
import com.jdc.demo.admin.dao.AdminDao;
import com.jdc.demo.member.dao.MemberDao;

@SpringJUnitConfig(classes = AppConfig.class)
public class PointCutDemoTest {
	
	@Autowired
	AdminDao dao;
	
	@Autowired
	MemberDao memberDao;

	@Test
	void test() {
		dao.searchSomething();
		
		memberDao.searchData();
	}
}
