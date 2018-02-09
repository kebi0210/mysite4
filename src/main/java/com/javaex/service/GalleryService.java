package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class GalleryService {

	public String restore(MultipartFile file) {
		
		String saveDir = "D:\\javaStudy\\upload";
		
		//파일 정보 수집
			
		
		//원 파일 이름
		String orgName = file.getOriginalFilename();

		System.out.println("원파일이름"+orgName);
		//확장자
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("확장자"+exName);
		
		//중복 파일 이름
		
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("중복파일"+saveName);
		//파일 위치(패스)
		String filePath = saveDir + "\\" + saveName;
		System.out.println("파일 위치"+filePath);
		
		//파일 사이즈
		
		long fileSize = file.getSize();
		System.out.println("파일사이즈"+fileSize);
		
		
		
		//파일 카피
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(saveDir + "/" + saveName);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(fileData);
			
			if(bout != null) {
				
				bout.close();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return saveName;
	}
	
}
