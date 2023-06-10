package com.jdc.spring.locations.model;

import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class PropertyDataSourceFactory {

	public static DataSource getPropsDataSource(Properties props) {
		var ds = new MysqlDataSource();
		ds.setUrl(props.getProperty("url"));
		ds.setUser(props.getProperty("user"));
		ds.setPassword(props.getProperty("password"));
		return ds;
	}

	public static DataSource getMapDataSource(Map<String, String> props) {
		var ds = new MysqlDataSource();
		ds.setUrl(props.get("url"));
		ds.setUser(props.get("user"));
		ds.setPassword(props.get("password"));
		return ds;
	}
}
