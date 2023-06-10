package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.jdbc.dto.Member;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(locations = { "/application-context.xml" })
public class PrepareStatementTest {

	@Autowired
	private JdbcOperations jdbc;
	
	@Autowired
	@Qualifier("memberRowMapper")
	private RowMapper<Member> rowMapper;

	@Test
	@DisplayName("1. Execute With Creator for Insert Statement")
	@Order(1)
	@Sql(scripts = "/database.sql")
	void test1(@Qualifier("memberInsert") PreparedStatementCreatorFactory factory) {

		PreparedStatementCreator creator = factory
				.newPreparedStatementCreator(List.of("admin", "admin", "Admin User", "09889988776", "admin@gmail.com"));

		var count = jdbc.execute(creator, PreparedStatement::executeUpdate);

		assertEquals(1, count);
	}

	@Test
	@DisplayName("2. Update With Creator")
	@Order(2)
	void test2(@Qualifier("memberInsert") PreparedStatementCreatorFactory factory) {

		PreparedStatementCreator creator = factory
				.newPreparedStatementCreator(List.of("member", "member", "Aung Aung", "09889988775", "aung@gmail.com"));

		var count = jdbc.update(creator);

		assertEquals(1, count);
	}

	@Test
	@DisplayName("3. Execute With Creator for Select Statement")
	@Order(3)
	void test3(@Qualifier("memberFindByNameLike") PreparedStatementCreatorFactory factory) {

		var result = jdbc.execute(factory.newPreparedStatementCreator(List.of("Admin%")), stmt -> {
			List<Member> list = new ArrayList<>();

			var rs = stmt.executeQuery();

			while (rs.next()) {
				var m = new Member();
				m.setLoginId(rs.getString(1));
				m.setPassword(rs.getString(2));
				m.setName(rs.getString(3));
				m.setPhone(rs.getString(4));
				m.setEmail(rs.getString(5));
				list.add(m);
			}

			return list;
		});

		assertEquals(1, result.size());
	}

	@Test
	@DisplayName("4. Query With Creator for Select Statement")
	@Order(4)
	void test4(@Qualifier("memberFindByNameLike") PreparedStatementCreatorFactory factory) {
		var result = jdbc.query(factory.newPreparedStatementCreator(List.of("Admin%")), rowMapper);
		assertEquals(1, result.size());
	}
	
	@Test
	@DisplayName("5. Query With Creator for Select by PK")
	@Order(5)
	void test5(@Qualifier("memberFindByPk") PreparedStatementCreatorFactory factory) {
		
		var result = jdbc.query(factory.newPreparedStatementCreator(List.of("member")), rs -> {
			while(rs.next()) {
				return rowMapper.mapRow(rs, 1);
			}
			return null;
		});
		
		assertNotNull(result);
		assertEquals("Aung Aung", result.getName());
	}
	
	@Test
	@DisplayName("6. Execute with Simple SQL String")
	@Order(6)
	@Sql(scripts = "/database.sql")
	void test6(@Value("${member.insert}") String sql) {
		
		var count = jdbc.execute(sql, (PreparedStatement stmt) -> {
			stmt.setString(1, "admin");
			stmt.setString(2, "admin");
			stmt.setString(3, "Admin User");
			stmt.setString(4, "098899889998");
			stmt.setString(5, "admin@gmail.com");
			return stmt.executeUpdate();
		});
		
		assertEquals(1, count);
	}
	
	@Test
	@DisplayName("7. Update with PreparedStatementSetter")
	@Order(7)
	@Sql(scripts = "/database.sql")
	void test7(@Value("${member.insert}") String sql) {
		
		int count = jdbc.update(sql, stmt -> {
			stmt.setString(1, "admin");
			stmt.setString(2, "admin");
			stmt.setString(3, "Admin User");
			stmt.setString(4, "098899889998");
			stmt.setString(5, "admin@gmail.com");
		});
		
		assertEquals(1, count);
	}
	
	@Test
	@DisplayName("8. Update with Parameter")
	@Order(8)
	@Sql(scripts = "/database.sql")
	void test8(@Value("${member.insert}") String sql) {
		int count = jdbc.update(sql, "admin", "admin", "Admin User", "09878889998", "admin@gmail.com");
		assertEquals(1, count);
	}
	
	@Test
	@Order(9)
	@DisplayName("9. Query with PreparedStatementSetter")
	void test9(@Value("${member.select.by.name}") String sql) {
		
		var list = jdbc.query(sql, stmt -> stmt.setString(1, "Admin%"), rowMapper);
		assertEquals(1, list.size());
	}
	
	@Test
	@Order(10)
	@DisplayName("10. Query with Parameters")
	void test10(@Value("${member.select.by.name}") String sql) {
		
		var list = jdbc.query(sql, rowMapper, "Admin%");
		assertEquals(1, list.size());
	}
	
	@Test
	@Order(11)
	@DisplayName("11. Select One with PreparedStatementSetter & ResultSetExtractor")
	void test11(@Value("${member.select.by.pk}") String sql) {
		
		var data = jdbc.query(sql, stmt -> stmt.setString(1, "admin"), rs -> {
			
			while(rs.next()) {
				return rowMapper.mapRow(rs, 1);
			}
			
			return null;
		});
		
		assertNotNull(data);
	}
	
	@Test
	@Order(12)
	@DisplayName("12. Select One with Params Using ResultSetExtractor")
	void test12(@Value("${member.select.by.pk}") String sql) {
		
		ResultSetExtractor<Member> extractor = rs -> {
			
			while(rs.next()) {
				return rowMapper.mapRow(rs, 1);
			}
			
			return null;
		};
		
		var data = jdbc.query(sql, extractor, "admin");
		
		assertNotNull(data);
	}
	
	@Test
	@Order(13)
	@DisplayName("13. Select One with Params ")
	void test13(@Value("${member.select.by.pk}") String sql) {
		var data = jdbc.queryForObject(sql, rowMapper, "admin");
		assertNotNull(data);
		assertEquals("Admin User", data.getName());
	}
	
	@Test
	@Order(14)
	@DisplayName("14. Select One Single Data with Params ")
	void test14() {
		var sql = "select count(*) from member where name like ?";
		var count = jdbc.queryForObject(sql, Long.class, "Admin%");
		assertEquals(1, count);
	}
	
}


