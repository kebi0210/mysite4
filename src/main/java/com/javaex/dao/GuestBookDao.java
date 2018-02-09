package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestBookVo> getlist() {
		//System.out.println("dao 진입");
		
	return sqlSession.selectList("guestbook.getlist");
	
	}
	
	public int getinsert(GuestBookVo guestbookVo) {
		
		//System.out.println("getinsert 진입");
		
		return sqlSession.insert("guestbook.insert",guestbookVo);
		
	}
	
	public void getdelete(int no, String password) {
		
		Map<String,Object>map = new HashMap<String,Object>();
		
		map.put("no", no);
		map.put("password", password);
		
		sqlSession.delete("guestbook.delete",map);
	}
	
	public List<GuestBookVo> selectGuestbookListPage(int page){
		
		return sqlSession.selectList("selectListByPage",page);
	}
	
	public int getinsertajax(GuestBookVo guestbookVo) {
		
		return sqlSession.insert("guestbook.insertajax",guestbookVo);
	}
	
	public GuestBookVo getselectList(int no) {
		
		return sqlSession.selectOne("guestbook.selectList", no);
	}
	
	public void getdeleteajax(int no) {
		
		int result = sqlSession.delete("guestbook.deleteajax", no);
		System.out.println(result + "건 삭제 완료");
	}
	
}
