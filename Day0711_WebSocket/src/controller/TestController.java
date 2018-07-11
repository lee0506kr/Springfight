package controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Message;

@Controller
public class TestController {
	
	@RequestMapping("/test")
	public String webSocketForm() {
		return "webSocketEx2";
	}
	
	@RequestMapping("/stomp")
	public String stompForm() {
		return "stomp";
	}
	
	@MessageMapping("/greeting/{memberid}/{targetid}")
	@SendTo("/topic/msg/{targetid}")
	public Message stompTest(String message,
			@DestinationVariable(value = "memberid")String memberid,
			@DestinationVariable(value = "targetid")String targetid) {
		System.out.println("memberid : " + memberid);
		System.out.println("targetid : " + targetid );
		/*얘가 동작하는 조건은 특정한 주소로 메시지를 받았을 때 실행 
		   /client/greeting
		  /client : servlet-context 에 
		   application-destination-prefix 로 선언됨 
		*/
		Message msg = new Message();
		msg.setBody(message);
		System.out.println("stompTest : message : " + message);
		return msg;
	}
	
	
	
	
	
}
