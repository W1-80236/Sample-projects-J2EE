package com.sunbeam.daos;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.pojos.User;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserRowMapper userRowMapper;
	
	public User findByEmail(String email) {
		String sql = "SELECT * FROM users WHERE email=?";
		List<User> list = jdbcTemplate.query(sql, userRowMapper, email);
		return list.isEmpty() ? null : list.get(0);
	}
	public int save(User u) {
		String sql = "INSERT INTO users(id, first_name, last_name, email, mobile, birth, password) VALUES(default, ?, ?, ?, ?, ?, ?)";
		int count = jdbcTemplate.update(sql, u.getId(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getMobile(), u.getBirth(),u.getPassword());
		return count;
		
	}
	public User findById(int id) {
		String sql = "SELECT * from users where id=?";
		List<User> list = jdbcTemplate.query(sql, userRowMapper, id);
		if(list.isEmpty())
			return null;
		else
			return list.get(0);
	}
	public List<User> findByName(String first_name){
		String sql = "SELECT * from users where first_name=?";
		List<User> list = jdbcTemplate.query(sql, userRowMapper, first_name);
		return list;
	}
	
	
	public  int deleteById(int id) {
		String sql ="DELETE from users where id=?";
		int count = jdbcTemplate.update(sql, id);
		return count;
		}
	public int update(User u) {
		String sql ="UPDATE users SET first_name=?, last_name=?, mobile=?, birth=? WHERE id=?";
		int count = jdbcTemplate.update(sql, u.getId(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getMobile(), u.getPassword());
		return count;
		
	}
	public List<User> findAll(User u){
		String sql = "Select * from users";
		List<User> list = jdbcTemplate.query(sql, userRowMapper);
		list.add(u);
		return list;
	}
	public int updatePassword(User u) {
		String sql ="UPDATE users SET password=? WHERE id=?";
		int count = jdbcTemplate.update(sql, u.getId(),  u.getPassword());
		return count;
		
	}
}
