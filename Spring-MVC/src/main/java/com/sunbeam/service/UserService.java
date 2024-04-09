package com.sunbeam.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.UserDao;
import com.sunbeam.pojo.Credentials;
import com.sunbeam.pojo.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public User authenticate(Credentials cr) {
		try {
			User user = userDao.findByEmail(cr.getEmail());
			if(user != null && user.getPassword().equals(cr.getPasswd()))
				return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
