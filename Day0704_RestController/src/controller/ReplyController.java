package controller;

import static org.hamcrest.CoreMatchers.allOf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Reply;
import service.ReplyService;

@Controller
@RequestMapping("/replies")
public class ReplyController {

	@Autowired
	ReplyService replyService;

	/*
	 * 요청 정리 댓글 등록 /replies method :post 댓글 수정 /replies/{replyNum} method : post 댓글
	 * 삭제 /replies/{replyNum} method : delete 댓글 목록 /replies/all/{boardNum} method :
	 * get
	 */
	// 등록요청 처리//value=""로 적어주면 컨트롤러 클래스에 적어놓은 url처리
	
	//ResponseEntity
	//응답할 때, 요청 처리 코드와 데이터를 함께 전달
	//메서드의 반환형은 ResponseEntity<T>
	//원래 반환 데이터가 boolean 이라면 ResponseEntity<Boolean>
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public boolean register(Reply reply) {
		// 파라미터로 전달 받은 데이터 insert 하고, 결과에 따라서
		// true/false 반환
		System.out.println("reply : " + reply);
		boolean result = replyService.addReply(reply);

		if (result) {
			return true;
		} else {
			return false;
		}
	}

	// replies?num=21 요청url+요청파라미터 , post 방식시 요청url board
	// Rest형태 의 요청 처리 하기 , 요청 url에 자원 또는 요청에 대한 정보가 모두 포함
	// ex) /replies/22
	// url자체에 포함된 변수 데이터를 받아오기 위해서 @PathVariable
	@ResponseBody
	@RequestMapping(value = "/all/{boardNum}")
	public ResponseEntity<List<Reply>> list(@PathVariable("boardNum") int boardNum) {

		
		ResponseEntity<List<Reply>> entity = null;
		

		try {
			List<Reply> replyList = replyService.getBoardReply(boardNum);
			entity = new ResponseEntity<List<Reply>>(replyList,HttpStatus.OK);
			
			
		}catch(Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	@ResponseBody
	@RequestMapping(value = "/{replyNum}", method = RequestMethod.POST)
	public ResponseEntity<String> update(@PathVariable("replyNum") int replyNum, String replyContent) {

		Reply reply = new Reply();
		reply.setReplyNum(replyNum);
		reply.setReplyContent(replyContent);
		//replyService.modifyReply(reply);
		ResponseEntity<String> entity = null;
		
		if(replyService.modifyReply(reply)) {
			//응답에 전달할 데이터, 요청상태 코드
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}else {
			entity = new ResponseEntity<String>("FAIL",HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
	}

	@ResponseBody
	@RequestMapping(value = "{replyNum}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable("replyNum") int replyNum) {

		System.out.println("delete 요청");

		return replyService.removeReply(replyNum);
	}

}
