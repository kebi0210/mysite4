package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public UserVo login(String email, String password) {
		
		return userDao.getUser(email,password);
		
		
	}
	
	public int insert(UserVo userVo) {
		
		return userDao.getinsert(userVo);
		
	}
	
	public UserVo modifyform(int no) {
		
		return userDao.getUser(no);
	}
	
	public Boolean emailCheck(String email) {
		boolean result;
		UserVo userVo = userDao.getUser(email);
		
		if(userVo != null) {
			
			result = false;
			
		} else {
			
			result = true;
			
		}
		
		return result;
		
	}
	
	public int modify(UserVo userVo) {
		
		return userDao.getupdateUser(userVo);
	}	
}
