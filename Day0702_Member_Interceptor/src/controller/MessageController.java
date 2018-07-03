package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MessageDao;
import service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	
	
	@Autowired
	private MessageService service;
	private MessageDao dao;
	
	
	@RequestMapping("/messageList")
	public String MessageList(Model model) {

		
		model.addAttribute("messageList",service.getAllMessages());
		
		
		
		return "messageList";
	}
	
	
}
