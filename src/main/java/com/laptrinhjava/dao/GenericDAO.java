package com.laptrinhjava.dao;

import java.util.List;

import com.laptrinhjava.mapper.RowMapper;

public interface GenericDAO<T> {
	// mot so ham can giai quyet query update insert count

	// query tra ve list
	<T>List<T> query(String sql, RowMapper<T> rowMapper,Object ... parameters);
	// count => dem duoc bao nhieu 
	int count(String sql, Object... parameters);

	// insert du lieu vao db
	Long insert(String sql, Object... parameters);

	// update
	void update(String sql, Object... parameters);
}
