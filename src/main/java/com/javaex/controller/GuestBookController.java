package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestBookService;
import com.javaex.vo.GuestBookVo;

@Controller
public class GuestBookController {
	
	@Autowired
	private GuestBookService guestbookService;
	
	@RequestMapping(value="/guestbook/list",method=RequestMethod.GET)
	public String list(Model model) {
		//System.out.println("list 진입");
		
		List<GuestBookVo> list = guestbookService.list();
		
		model.addAttribute("list",list);
		
		return "guestbook/list";
		
	}
	
	@RequestMapping(value="/guestbook/insert",method=RequestMethod.GET)
	public String insert(@ModelAttribute GuestBookVo guestbookVo) {
		
		//System.out.println("insert 진입");
		
		guestbookService.insert(guestbookVo);
		
		return "redirect:/guestbook/list";
		
	}
	
	@RequestMapping(value="/guestbook/deleteform",method=RequestMethod.GET)
	public String deleteform() {
		
		//System.out.println("deleteform 진입");
		
		return "guestbook/deleteform";
	}
	
	@RequestMapping(value="/guestbook/delet",method=RequestMethod.POST)
	public String delete(@ModelAttribute GuestBookVo guestbookVo ) {
		//System.out.println("delete진입");
		guestbookService.delete(guestbookVo.getNo(),guestbookVo.getPassword());
		
		return "redirect:/guestbook/list";
		
	}
	
	@RequestMapping(value="/guestbook/listajax",method=RequestMethod.GET)
	public String listajax() {
		
		
		return "guestbook/listajax";
		
	}
	
		
}
