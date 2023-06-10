package com.jdc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.jdbc.dao.MemberDao;
import com.jdc.jdbc.dto.Member;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(locations = "/application-context.xml")
public class MemberDaoTest {

	@Autowired
	private MemberDao dao;
	
	@Autowired
	private JdbcOperations dbOperations;
	
	@Value("ddl.member.create")
	String createTable;
	
	@Test
	@Sql(scripts = "/database.sql")
	@Order(1)
	void testCreate() {
		Member m = new Member();
		m.setLoginId("admin");
		m.setPassword("admin");
		m.setName("Admin");
		
		dao.create(m);
	}
	
	@Test
	@Order(2)
	void testUsingConnection() {
		
		var data = dbOperations.execute((Connection conn) -> {
			var stmt = conn.createStatement();
			var rs = stmt.executeQuery("select count(*) from member");
			while(rs.next()) {
				return rs.getLong(1);
			}
			return 0;
		});
		
		assertEquals(1L, data);
		
	}
	
	@Test
	@Order(3)
	void testUsingStatement() {
		var data = dbOperations.execute((Statement stmt) -> {
			return stmt.executeUpdate("""
					insert into member(loginId, password, name) values 
					('Member', 'Member', 'Thidar')
					""");
		});
		assertEquals(1, data);
	}
	
	@Test
	@Order(4)
	void testStaticQueryResultSetExtractor() {
		var result = dbOperations.query("select count(*) from member", rs -> {
			while(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		});
		
		assertEquals(2, result);

		var list = dbOperations.query("select * from member", rs -> {
			var data = new ArrayList<Member>();
			while(rs.next()) {
				var m = new Member();
				m.setLoginId(rs.getString(1));
				m.setPassword(rs.getString(2));
				m.setName(rs.getString(3));
				m.setPhone(rs.getString(4));
				m.setEmail(rs.getString(5));
				data.add(m);
			}
			return data;
		});
		assertEquals(2, list.size());
	}
	
	@Test
	@Order(5)
	void testStaticQueryRowCallbackHandler() {
		
		var list = new ArrayList<Member>();

		dbOperations.query("select * from member", rs -> {
			var m = new Member();
			m.setLoginId(rs.getString(1));
			m.setPassword(rs.getString(2));
			m.setName(rs.getString(3));
			m.setPhone(rs.getString(4));
			m.setEmail(rs.getString(5));
			
			list.add(m);
		});

		assertEquals(2, list.size());
	}
	

	@Test
	@Order(6)
	void testStaticQueryRowMapper() {
		var list = dbOperations.query("select * from member", 
				(rs, no) -> {
					var m = new Member();
					m.setLoginId(rs.getString(1));
					m.setPassword(rs.getString(2));
					m.setName(rs.getString(3));
					m.setPhone(rs.getString(4));
					m.setEmail(rs.getString(5));
					return m;
				});
		
		assertEquals(2, list.size());
	}
	
	@Test
	@Order(7)
	void testStaticQueryOneResultWithClass() {
		var count = dbOperations.queryForObject("select count(*) from member", Long.class);
		assertEquals(2L, count);
		
		var m = dbOperations.queryForObject("select name from member where loginId = 'admin'", String.class);
		assertEquals("Admin", m);
	}
}
