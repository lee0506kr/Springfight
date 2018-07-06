package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;

	
	
	@RequestMapping("/boardList")
	public String BoardList(Model model,@RequestParam(value="page",defaultValue= "1" ) int pageNumber) {
	
		model.addAttribute("viewData",service.getBoardList(pageNumber));
		System.out.println(service.getBoardList(pageNumber));
		
		return "boardList";
	}
	
	@RequestMapping("/boardView")
	public String BoardView(Model model,int num) {
	

		
		model.addAttribute("board",service.getOneBoard(num));
	
		
	
		return "boardView";
	}
	
	
	@RequestMapping("/boardWrite")
	public String BoardWriteForm(Map<String, Object> board) {

		return "boardWrite";
	}
	
	
	
	@RequestMapping("/write")
	public String BoardWrite(@RequestParam Map<String, Object> board) {

		
		service.writeBoard(board);
		
		
		
		
		return "redirect:boardList";
	}
	
	@RequestMapping("/boardCheckPass")
	public String BoardDeleteForm(Model model, int num, String pw) {

		return "boardCheckPass";
	}
	
	
	@RequestMapping("/board_check_pass")
	public String BoardDelete(Model model,@RequestParam Map<String, Object> board) {
		
		
		service.deleteBoard(board)
		
		return "redirect:boardList";
	}
	
	
	
	
	
	
	
}
