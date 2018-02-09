package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/loginform",method=RequestMethod.GET)
	public String loginform() {
		
		return"user/loginform";
	}
	
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	public String login(@RequestParam("email") String email, 
						@RequestParam("password")String password,
						HttpSession session) {
		
		UserVo authUser = userService.login(email, password);
		
		if(authUser != null) {
			session.setAttribute("authUser", authUser);
			
			return"main/index";
			
		}else {
			
			return "redirect:/user/loginform?result=fail";
			
		}	
	}
	
	@RequestMapping(value="/user/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "main/index";
	}
	
	@RequestMapping(value="/user/joinform", method=RequestMethod.GET)
	public String joinform() {
		
		
		return "user/joinform";
		
	}
	
	@RequestMapping(value="/user/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute UserVo userVo) {
		
		userService.insert(userVo);
		
		return "user/joinsuccess";
		
	}
	
	@RequestMapping(value="/user/modifyform",method=RequestMethod.GET)
	public String modifyform(HttpSession session, Model model) {
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if(authUser == null) {
			
			return "user/loginform";
			
		}else {
			
			UserVo userVo = userService.modifyform(authUser.getNo());
			model.addAttribute(userVo);
			
			return "user/modifyform";	
		}	
	}
	
	@RequestMapping(value="user/modify", method=RequestMethod.POST)
	public String modify(HttpSession session,@ModelAttribute UserVo userVo,String name) {
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if(authUser == null) {
			
			return "user/loginform";
		
		}else {
			
			userVo.setNo(authUser.getNo());
			
			userService.modify(userVo);
			
			authUser.setName(name);
			
			return "main/index";
		}
	}
}
