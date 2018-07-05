package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.NaverBookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	
	@Autowired
	NaverBookService naverBookService;
	
	@RequestMapping("/bookSearch")
	public String bookSearch(
			@RequestParam(required=false,defaultValue = "")String keyword,Model model) {
		
		System.out.println("/bookSearch 요청 받았습니다. 검색어  : " + keyword);
			
			//검색어를 이용해서 네이버에 요청하고 응답을 받는다. 
			//응답받은 데이터를 모델로 만들어서 jsp로 전달
			//위의 작업을 service에서 처리 
		
			try {
				model.addAttribute("bookList",naverBookService.SearchBooks(keyword));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		return "bookList";
	}
}
