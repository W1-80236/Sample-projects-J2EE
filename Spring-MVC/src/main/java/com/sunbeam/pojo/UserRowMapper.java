package com.sunbeam.pojo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UserRowMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String password = rs.getString("password");
		String mobile = rs.getString("mobile");
		String email = rs.getString("email");
		String address = rs.getString("address");
		Date birth = rs.getDate("birth");
		int enabled = rs.getInt("enabled");
		String role = rs.getString("role");
		User u = new User(id, name, password, mobile, email, address, birth, enabled, role);
		return u;
	}
}
