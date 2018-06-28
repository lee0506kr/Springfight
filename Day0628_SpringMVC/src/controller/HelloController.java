package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.StudentService;

@Controller
public class HelloController {
	
	@Autowired
	private StudentService service;
	
	
	@RequestMapping("/hello.do")
	public ModelAndView test() {
//		System.out.println("123123");
		//화면 출력하기 위해서는. 어떤 화면을 출력할지 결정해줘야 함
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg", "Hello!! world!!");
		mav.setViewName("hello.jsp");
		return mav;
	}
	
	@RequestMapping("/studentList.do")
	public ModelAndView showStudentList() {
		//서비스에서 학생정보 읽어오기
		//읽어온 학생정보를 modelandview에 넣어주기 
		//mav 반환
//		System.out.println("studentList: " + service.getAllStudents());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("studentList", service.getAllStudents());
		mav.setViewName("studentList.jsp");
		
		return mav;
	}
	
	
	
	
}
