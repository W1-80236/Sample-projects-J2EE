package com.sunbeam.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.pojo.User;
import com.sunbeam.pojo.UserRowMapper;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserRowMapper userRowMapper;
	
	public User findByEmail(String email) throws Exception {
		String sql = "SELECT * FROM users WHERE email=?";
		List<User> list = jdbcTemplate.query(sql, userRowMapper, email);
		return list.isEmpty() ? null : list.get(0);
	}
}	


