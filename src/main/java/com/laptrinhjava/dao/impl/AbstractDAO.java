package com.laptrinhjava.dao.impl;

import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;

import com.google.protobuf.TimestampProto;
import com.laptrinhjava.dao.GenericDAO;
import com.laptrinhjava.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	// can ket noi duoc voi sql

	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

	public Connection getConnection() {
		try {
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	// tien su li du lieu
	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			Long len_parameters = (long) parameters.length;
			for (int i = 0; i < len_parameters; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if (parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) null);
				} else if (parameter == null) {
					statement.setNull(index, Types.NULL);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// thuc hien tinh nang
	@Override
	public int count(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			int count = 0;
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			// dung cai na doc parameter tu sql
			setParameter(statement, parameters);
			// thuc hien cau query
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}

			return count;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e2) {
				return 0;
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		Long id = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
				
			}
			// luu lai id			
			connection.commit();
			return id;
		} catch (Exception e) {
			// TODO: handle exception
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				} finally {
					try {
						if (connection != null) {
							connection.close();
						}
						if (statement != null) {
							statement.close();
						}

					} catch (SQLException e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			}
		}
		return null;
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			// ngan chan hanh dong tu dong kiem soat hoat do ng tu model chinh
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();

		} catch (Exception e) {
			// TODO: handle exception
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				} finally {
					try {
						if (connection != null) {
							connection.close();
						}
						if (statement != null) {
							statement.close();
						}

					} catch (SQLException e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {

		return null;
	}

}
