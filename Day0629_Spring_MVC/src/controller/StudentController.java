package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	//    '학생 관련 요청은 모두 StudentController 가 처리 '
	// 학생관련 요청은     /student/studentList
	//            /student/add?name= $grade = 
	//의 형식으로 앞쪽에 /student를 붙여준다.
	@Autowired
	private StudentService service;
	
	@RequestMapping("/studentList")
	public String StudentList(Model model,@RequestParam(value = "grade",defaultValue="1") int g) {
//		/student/studentList.do?grade=2
//		System.out.println("studentList.do 진입합니다!!");
//		System.out.println("grade : " + g);
		List<Map<String, Object>> list 
		= service.selectStudentsByGrade(g);
		
//		System.out.println("list : " + list);
		model.addAttribute("grade", g);
		model.addAttribute("studentList", list);
		
		return "studentList";
	}
	
	
	//학생 정보 입력 창 요청
		@RequestMapping("/studentAddForm")
		public String studentAddForm() {
			return "addStudent";
		}
	@RequestMapping("/addStudent")
	public String studentAdd( String name , int grade) {
		//서비스에 파라미터로 넘어온 데이터를 전달
		//서비스는 파라미터로 넘어온 데이터를 dao에 전달
		//dao는 insert
		
		service.addStudent( name, grade);
		
		
		
		
		
		return "redirect:studentList?grade="+grade;
	}









}
