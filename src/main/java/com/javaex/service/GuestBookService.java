package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Service
public class GuestBookService {
	
	@Autowired
	private GuestBookDao guestbookDao;
	
	public List<GuestBookVo> list() {
		
		return guestbookDao.getlist();
		
	}
	
	public int insert(GuestBookVo guestbookVo) {
		
		return guestbookDao.getinsert(guestbookVo);
		
	}
	
	public void delete(int no, String password) {
		
		guestbookDao.getdelete(no, password);
	}
	
	public List<GuestBookVo> getGuestbookListPage(int page){
		
		return guestbookDao.selectGuestbookListPage(page);
	}
	
	public int insertajax(GuestBookVo guestbookVo) {
		
		return guestbookDao.getinsertajax(guestbookVo);
	}
	
	public GuestBookVo selectList(int no){
		
		return guestbookDao.getselectList(no);
	}
	
	public boolean deleteajax(GuestBookVo guestbookVo) {
		
		boolean reault;
		
		GuestBookVo gbv = guestbookDao.getselectList(guestbookVo.getNo());
		
		if(guestbookVo.getPassword().equals(gbv.getPassword())) {
		
			guestbookDao.getdeleteajax(guestbookVo.getNo());
		
			reault = true;
			
		}else {
			reault = false;
		}
		
		return reault;
		
		
		
		
	}
}
