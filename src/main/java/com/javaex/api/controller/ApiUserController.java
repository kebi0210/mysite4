package com.javaex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class ApiUserController {
	
	@Autowired	
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/user/api/emailcheck", method=RequestMethod.POST)
	public boolean emailcheck(@RequestBody UserVo userVo) {
		System.out.println(userVo.toString());
		//boolean result = userService.emailCheck(email);
		//System.out.println(result);
		
		
		return true;
	}
	@ResponseBody
	@RequestMapping(value = "/user/api/jsontest", method=RequestMethod.GET)
	public UserVo jsontest() {
	
		UserVo userVo = userService.modifyform(63);
		
		return userVo;

	}
}