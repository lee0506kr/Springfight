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
	public String BoardDeleteForm(Model model, int num) {

		return "boardCheckPass";
	
	}
	
	
	@RequestMapping("/board_check_pass")
	public String checkpass(Model model,int num) {

		if(service.getOneBoard(num) != null) {
			System.out.println("board_check_pass: 123");
			return "checkSuccess";
		}else {
			System.out.println("board_check_pass : 234");
			model.addAttribute("msg","비밀번호가 틀려습니다.");
			return "boardCheckPass";
		}
	
	}
	
	
	@RequestMapping("/delete")
	public String boardDelte(int num, Model model) {
		String msg ="";
		String url ="";
		
		boolean reuslt = service.deleteBoard(num);
		if(reuslt) {
			msg = "삭제 성공";
			url ="boardList";
			
		}else {
			
			msg = "삭제 실패";
			url ="boardView";
	
		}
		
		model.addAttribute("msg",msg);
		model.addAttribute("url",url);
		return "result";
		
	}
	
	
	
	@RequestMapping("/boardModify")
	public String BoardModifyForm(Model model, int num) {

		model.addAttribute("board",service.getOneBoard(num));
		
		return "boardModify";
	}
	
	
	@RequestMapping("/update")
	public String BoardModify(Model model,@RequestParam Map<String, Object> board,int num) {

		String msg ="";
		String url ="";
	
		
		boolean reuslt = service.modifyBoard(board);
		
		if(reuslt) {
			
			
			msg = "수정 성공";
			url = "boardView?num="+num;
			
		}else {
			
			msg = "수정 실패";
			url = "boardModify";
	
		}
		
		model.addAttribute("msg",msg);
		model.addAttribute("url",url);
		
		return "result";
		
		
	}
	
	
	
	
	
	
	
}
