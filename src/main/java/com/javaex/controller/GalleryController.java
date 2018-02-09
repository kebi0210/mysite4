package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.javaex.service.GalleryService;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService gallervService;
	
	
}
