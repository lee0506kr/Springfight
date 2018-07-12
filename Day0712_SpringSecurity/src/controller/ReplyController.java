package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/replies")
public class ReplyController {
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("replies test 입니다. ");
		
		return "test";
	}
	
}


















