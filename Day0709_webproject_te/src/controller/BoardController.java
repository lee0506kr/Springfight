package controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;

import commons.DownloadView;
import service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	//서비스 
	@Autowired
	BoardService boardService;
	
	
//	/boardList 			 : 게시글 목록보기
	@RequestMapping("/boardList")
	public String boardList(Model model,@RequestParam(value="page",defaultValue= "1" ) int pageNumber) {
		
		List<Map<String, Object>> bList = boardService.boardList();
		model.addAttribute("boardList", boardService.boardList());
		System.out.println("bList : " + bList);
		//model.addAttribute("viewData",boardService.getBoardList(pageNumber));
		
		model.addAttribute("boardList", bList);
		
		return "boardList";
	}
//	/view      			 : 게시글 상세보기
	@RequestMapping(value = "/view")
	public String view(int num,Model model) {
		//서비스를 이용해서 게시글 정보 하나 얻어오고, 화면 이동
		Map<String, Object> board 
		= boardService.readBoard(num);
		System.out.println("controller view : " + board);
		
		model.addAttribute("board",board);
		
		return "boardView";
	}	
//	/write,method = get  : 게시글 작성 양식 요청 
	@RequestMapping(value = "/write", method=RequestMethod.GET)
	public String writeForm() {
		return "boardWrite";
	}
	
//	/write,method = post : 게시글 작성 요청
	@RequestMapping(value = "/write",method = RequestMethod.POST)
	public String write(@RequestParam Map<String,Object> board
			,Model model
			,MultipartFile file) {
		
//		System.out.println("BoardController write file :  " + file);
//		System.out.println("BoardController write Map :  " + board);
		if(boardService.writeBoard(board, file)) {
			model.addAttribute("msg", "등록완료");
		}else {
			model.addAttribute("msg", "등록실패");
		}
		model.addAttribute("url", "boardList");
	 
		return "result";
	}
//  /download  
	@RequestMapping("/download")
	public View download(int num) {
		//우리가 반환할 View를 만들어서 
		//객체를 반환하면 됨
		File file = boardService.getAttachFile(num);
		View view = new DownloadView(file);
		return view;
	}	
//	/modifyForm   		 : 수정양식 요청
	@RequestMapping(value = "/modifyForm")
	public String modifyForm(int num,Model model) {
		model.addAttribute("board", boardService.getBoard(num));
		return "boardModify";
	}
	
//	/modify		         : 수정요청
	@RequestMapping(value ="/modify")
	public String modify(@RequestParam Map<String, Object> board,Model model) {
		model.addAttribute("url", "view?num=" +board.get("NUM"));
		if(boardService.modifyBoard(board)) {
			model.addAttribute("msg", "수정완료");
		}else {
			model.addAttribute("msg", "수정실패");
		}
		return "result";
	}
//	/delete 			 : 게시글 삭제요청
	@RequestMapping(value = "/delete")
	public String delete(int num,Model model) {
		model.addAttribute("url", "boardList");
		if(boardService.removeBoard(num)) {
			model.addAttribute("msg", "삭제완료");
		}else {
			model.addAttribute("msg", "삭제실패");
		}
		return "result";
	}
	
//	/boardCheckPassForm  : 비밀번호 확인 양식 요청
	@RequestMapping(value = "/boardCheckPassForm")
	public String boardCheckPassForm() {
		return "boardCheckPass";
	}
//	/boardCheckPass 	 : 비밀번호 확인 요청
	
	@RequestMapping(value = "/boardCheckPass")
	public String boardCheckPass(@RequestParam Map<String,Object> params
			,Model model) {
		//입력받은 비밀번호와 게시글의 비밀번호를 비교
		//성공하면, checkSuccess.jsp 실패하면 boardCheckPass.jsp
		System.out.println("boardController boardCheckPass: " + params );
		if(boardService.checkPass(params)) {
		
			return "checkSuccess";
		}else {
			
			model.addAttribute("msg","비밀번호가 틀렸습니다.");
			return "boardCheckPass"; 	
		}
	}		
}










