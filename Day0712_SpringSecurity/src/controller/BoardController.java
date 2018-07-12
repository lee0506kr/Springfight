package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@RequestMapping("/boardList")
	public String boardList() {
		System.out.println("야호!!");
		return "boardList";
	}
}






















