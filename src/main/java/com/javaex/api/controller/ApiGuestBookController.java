package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestBookService;
import com.javaex.vo.GuestBookVo;

@Controller
public class ApiGuestBookController {
	
	@Autowired
	private GuestBookService guestbookService;
	
	@ResponseBody
	@RequestMapping(value="/guestbook/api/list",method=RequestMethod.POST)
	public List<GuestBookVo> apilist(@RequestParam("page") int page) {
		//System.out.println("list진입");
		
		
		List<GuestBookVo> guestbooklist = guestbookService.getGuestbookListPage(page);
	
		//System.out.println(guestbooklist.toString());
		
		
		return guestbooklist;
	}
	
	@ResponseBody
	@RequestMapping(value="/guestbook/api/insertajax",method=RequestMethod.POST)
	public GuestBookVo insertajax(@RequestBody GuestBookVo guestbookVo) {
		//System.out.println("insertajax 진입");
		//System.out.println(guestbookVo.toString());
		
		guestbookService.insertajax(guestbookVo);
	
		return guestbookVo;
	
	}
	
	@ResponseBody
	@RequestMapping(value="/guestbook/api/selectList",method=RequestMethod.POST)
	public GuestBookVo selectList(@RequestParam("no")int no){
		
		GuestBookVo selectList = guestbookService.selectList(no);
		
		return selectList;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/guestbook/api/deleteajax",method=RequestMethod.POST)
	public Boolean deleteajax(@RequestBody GuestBookVo guestbookVo) {
		
		boolean result = guestbookService.deleteajax(guestbookVo);
		
		
		return result;
		
	}
	
}
