package com.jdc.spring.locations.model.dao.impl;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.springframework.util.StringUtils;

import com.jdc.spring.locations.model.dao.StateDao;
import com.jdc.spring.locations.model.dto.State;

public class StateDaoImpl implements StateDao{
	
	private DataSource dataSource;
	
	@PostConstruct
	public void afterInit() {
		System.out.println("Dao is Ready to use.");
	}
	
	@PreDestroy
	public void beforeDestory() {
		System.out.println("Dao has been destroy.");
	}
	
	public void setSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public State create(State state) {
		
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(
						"insert into state values (?, ?, ?, ?, ?, ?)", 
						Statement.RETURN_GENERATED_KEYS)) {
			
			stmt.setInt(1, state.id());
			stmt.setString(2, state.name());
			stmt.setString(3, state.burmese());
			stmt.setString(4, state.capital());
			stmt.setString(5, state.region());
			stmt.setString(6, state.type());
			
			stmt.executeUpdate();
			
			var rs = stmt.getGeneratedKeys();
			
			while(rs.next()) {
				var id = rs.getInt(1);
				return state.withId(id);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public State findById(int id) {
		
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement("select * from state where id = ?")) {
			stmt.setInt(1, id);
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				return new State(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<State> search(String keyword) {
		
		var list = new ArrayList<State>();
		var sb = new StringBuffer("select * from state ");
		
		if(StringUtils.hasLength(keyword)) {
			sb.append("where lower(name) like ? or lower(type) like ? or lower(region) like ?");
		}
		
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(sb.toString())) {
			
			if(StringUtils.hasLength(keyword)) {
				stmt.setString(1, "%".concat(keyword.toLowerCase().concat("%")));
				stmt.setString(2, "%".concat(keyword.toLowerCase().concat("%")));
				stmt.setString(3, "%".concat(keyword.toLowerCase().concat("%")));
			}

			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				list.add(new State(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		
		return list;
	}

}
