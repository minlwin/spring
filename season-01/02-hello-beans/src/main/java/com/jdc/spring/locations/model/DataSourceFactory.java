package com.jdc.spring.locations.model;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DataSourceFactory {
	
	private String url, user, pass;
	
	public DataSourceFactory(String url, String user, String pass) {
		super();
		this.url = url;
		this.user = user;
		this.pass = pass;
	}

	public DataSource mysqlDataSource() {
		var ds = new MysqlDataSource();
		ds.setUrl(url);
		ds.setUser(user);
		ds.setPassword(pass);
		return ds;
	}

}
