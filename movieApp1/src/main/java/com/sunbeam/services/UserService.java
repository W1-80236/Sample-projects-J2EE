package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.UserDao;
import com.sunbeam.pojos.Credentials;
import com.sunbeam.pojos.Review;
import com.sunbeam.pojos.User;

@Service
	public class UserService {
		@Autowired
		private UserDao userDao;
		
		public User authenticate(Credentials cr) {
			User user = userDao.findByEmail(cr.getEmail());
			if(user != null && user.getPassword().equals(cr.getPasswd()))
				return user;
			return null;
		}

		public int saveUser(User user) {
			int count = userDao.save(user);
			return count;
		}
		public User findUserById(int id) {
			User u= userDao.findById(id);
			return u;
		}


		public int editPassword(Credentials cr,int userId) {
		  int count = userDao.updatePassword(cr,userId);
		    return count;
			
		}
		public List<User> getAllUser() {
			List<User> list = userDao.findAll();
			return list;
		}
		

}
