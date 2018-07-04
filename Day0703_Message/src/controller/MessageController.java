package controller;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Message;
import service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService service;

		
	@RequestMapping("/messageList")
	public String MessageList(Model model,@RequestParam(value="page",defaultValue= "1" ) int pageNumber) {
	
		model.addAttribute("viewData",service.getMessageList(pageNumber));
		
		
		return "messageList";
	}
	
	@RequestMapping("/write")
	public String writeMessage(Message message) {
		
		
		service.writeMessage(message);
		
		
		return "redirect:messageList";
	}
	
	
	@RequestMapping("/confirmDeletion")
	public String deleteMessage() {
		
		System.out.println("confirmDeletion");
		
		
		return "confirmDeletion";
	}
	
	@RequestMapping("/pwCheck")
	public String pwCheck(Model model,int id, String password) {
		
		System.out.println("들어온다");
		
		model.addAttribute(service.deleteMessage(id, password));

		return "redirect:messageList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
