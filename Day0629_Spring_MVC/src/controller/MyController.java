package controller;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("/test")
	public String test(Model model) {
		System.out.println("test.do 요청입니다.");
		// 이렇게.jsp 등 경로 없이
		// 이렇게 사용하기 위해서 viewResolver 설정 바꿔줘야 함

		model.addAttribute("msg", "test요청을 받았습니다.!!");

		return "test";

	}

	@RequestMapping("/whatTime")
	public String whatTime(Model model) {

		Date date = new Date();

		model.addAttribute("msg", date);

		return "whatTime";
	}

	// whatTime.do 요청받아서
	// 화면에 현재 시간 출력하기

}
