
package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojos.User;


public class UserDao implements AutoCloseable {
	private Connection con;
	
	public UserDao() throws Exception {
		con = DbUtil.getConnection();
	}

	@Override
	public void close() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
		}
	}
	
	public User findByEmail(String email) throws Exception {
		String sql = "SELECT * FROM users WHERE email=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, email);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String password = rs.getString("password");
					String mobile = rs.getString("mobile");
					email = rs.getString("email");
					String address = rs.getString("address");
					Date birth = rs.getDate("birth");
					int enabled = rs.getInt("enabled");
					String role = rs.getString("role");
					User u = new User(id, name, password, mobile, email, address, birth, enabled, role);
					return u;
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}
	
	public int save(User u) throws Exception {
		String sql ="insert into users(name, mobile, email, password, address, birth, enabled, role) values (?,?,?,?,?,?,?,?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getMobile());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getPassword());
			stmt.setString(5, u.getAddress());
			stmt.setDate(6, u.getBirth());
			stmt.setInt(7, u.getEnabled());
			stmt.setString(8, u.getRole());
			int count = stmt.executeUpdate();
			return count;
		}
	}

	public int update(User u) throws Exception {
		// TODO update user name, mobile, email, birth date for given id
		//return 0;
		String sql = "update user set name =?, mobile=?, email=?, password=?, address=?, birth=?,where id=?";
		
		try(PreparedStatement stmt = con.prepareStatement(sql))
		{
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getMobile());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getPassword());
			stmt.setString(5, u.getAddress());
			stmt.setDate(6, u.getBirth());
			stmt.setInt(7, u.getEnabled());
			stmt.setString(8, u.getRole());
			stmt.setInt(9, u.getId());
			
			int count = stmt.executeUpdate();
			System.out.println("Rows Updated: " + count);
			return count;
			
		}
	}
	

	public int deleteById(int id) throws Exception {
		// TODO delete user of given id
		//return 0;
		String sql = "DELETE FROM user WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			int count = stmt.executeUpdate();
			return count;
		} // stmt.close();
	}
	
	public List<User> findAll() throws Exception {
		// TODO return all users
		//return null;
		List<User> list = new ArrayList<>();
		String sql = "SELECT * FROM user";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
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
					list.add(u);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}
}
























