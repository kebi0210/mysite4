package com.javaex.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
		
		@Autowired
		private SqlSession sqlSession;
		
		public UserVo getUser(String email,String password) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("email",email);
			map.put("password",password);
			
			return sqlSession.selectOne("selectUser",map);
			
		}
		
		public int getinsert(UserVo userVo) {
		
			return sqlSession.insert("insert", userVo);
			
		}
		
		public UserVo getUser(int no) {
			
			return sqlSession.selectOne("modifyform",no);
			
		}
		
		public int getupdateUser(UserVo userVo) {
			
			return sqlSession.update("modify",userVo);
			
		}
		
		public UserVo getUser(String email) {
			
			UserVo userVo = sqlSession.selectOne("user.selectUserByEmail",email);
			
			return userVo;
			
		}
	
}
