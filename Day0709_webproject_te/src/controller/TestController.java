package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("/imageView")
	public String imageView() {
		return "image";
	}
	
	@RequestMapping("/image")
	@ResponseBody
	public byte[] getImageAsByteArray(String fileName) {
		//특정 이미지 읽어와서 byte[] 배열로 만들어서 반환
		// C:\boardImage
		System.out.println("/image 요청 받음");
		//파일 읽어오기 
		File originFile = new File("C:/boardImage/"+fileName);
		
		InputStream targetStream = null;
		
		try {
			targetStream = new FileInputStream(originFile);	
			//스트림을 byte[] 변환하기 >> IOUtils, commons.io
			System.out.println("/image 요청 받음");
			//파일 읽어오기 
			return IOUtils.toByteArray(targetStream);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
}
