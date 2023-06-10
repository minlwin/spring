package com.jdc.security.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.jdc.security.services.model.AccessInfo;
import com.jdc.security.services.model.AccessInfo.Type;

@Service
public class AccessInfoService {

	@Autowired
	private SimpleJdbcInsert accessInfoInsert;
	private RowMapper<AccessInfo> rowMapper;
	
	public AccessInfoService() {
		rowMapper = new BeanPropertyRowMapper<AccessInfo>(AccessInfo.class);
	}

	public void create(String loginId, Type type) {
		if (!"admin".equals(loginId)) {
			accessInfoInsert.execute(Map.of("login_id", loginId, "type", type.name()));
		}
	}
	
	public List<AccessInfo> getInfo(String loginId) {
		return accessInfoInsert.getJdbcTemplate().query("""
				select a.id, a.login_id loginId, u.name userName, a.type, a.access_time accessTimeStamp from 
				access_info a join user u on u.login = a.login_id where a.login_id = ? 
				order by a.access_time desc
				""", 
				stmt -> stmt.setString(1, loginId), 
				rowMapper);
	}
	
	public List<AccessInfo> getAllInfo() {
		return accessInfoInsert.getJdbcTemplate().query("""
				select a.id, a.login_id loginId, u.name userName, a.type, a.access_time accessTimeStamp from 
				access_info a join user u on u.login = a.login_id 
				order by a.access_time desc
				""", 
				rowMapper);
	}

}
