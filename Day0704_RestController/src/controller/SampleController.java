package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.MemberService;

@Controller
@RequestMapping("/sample")
public class SampleController {
	
	@Autowired
	private MemberService service;
	
	
	@ResponseBody
	@RequestMapping("/hello")
	public Map<String, Object> test() {
		System.out.println("sample/hello 요청 받았습니다.");
		
		Map<String, Object> testMap = new HashMap<String,Object>();
		testMap.put("test","testmap 입니다.");
		
		return testMap;
	}
	
	@ResponseBody
	@RequestMapping("/memberList")
	public List<Map<String, Object>> memberList() {
		System.out.println("sample/hello 요청 받았습니다.");
		
		
		return service.selectAll();
	}
	
	@RequestMapping("/board/{boardNum}")
	public String board(@PathVariable("boardNum")int num) {
		
		return "reply";
	}
	
	
	
}
