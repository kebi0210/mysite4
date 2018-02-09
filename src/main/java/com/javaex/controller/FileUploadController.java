package com.javaex.controller;

import org.springframework.stereotype.Controller;

@Controller

public class FileUploadController {
//	
//	@Autowired
//	private FileUploadService fileuploadService;
//	
//	
//	@RequestMapping("/fileupload/form")
//	public String form() {
//		
//		System.out.println("form 진입");
//		
//		return"/fileupload/form";
//	}
//	
//	@RequestMapping(value="/fileupload/upload")
//	public String upload(@RequestParam("file") MultipartFile file,Model model) {
//		System.out.println(file.toString());
//		
//		String saveName = fileuploadService.restore(file);
//		
//		String url = "upload/" + saveName;
//		
//		model.addAttribute("url", url);
//		System.out.println("url  "+ url);
//		return"/fileupload/result";
//	}
//	
}
