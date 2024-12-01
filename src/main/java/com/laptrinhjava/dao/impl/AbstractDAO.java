package com.laptrinhjava.dao.impl;

import java.util.List;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjava.dao.GenericDAO;
import com.laptrinhjava.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T>{
	// can ket noi duoc voi sql 
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	public Connection getConnection() {
		try {
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		}
		catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
	
	
	// tien su li du lieu 
//	private void setParameter(PreparedStatement statement , Object ...parameters) {
//		try {
//			Long len_parameters = (long) parameters.length;
//			for (int i =0;i < len_parameters;i++) {
//				Object parameter = parameters[i];
//			}
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	// thuc hien tinh nang
	@Override
	public int count(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			int count = 0;
			connection = getConnection();
			statement  = connection.prepareStatement(sql);
//			setParameter(statement, parameters);

			
			return 0;
		}
		catch (Exception e) {
			// TODO: handle exception
			
		}
		
		return 0;
	}

	@Override
	public Long insert(String sql, Object... parameters) {

		return null;
	}

	@Override
	public void update(String sql, Object... parameters) {
		
		
	}


	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
	
		return null;
	}
	
}
