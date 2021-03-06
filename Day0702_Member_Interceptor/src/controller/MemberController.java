package controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dao.MemberDao;
import model.Member;
import service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	//SetCharacterEncodingFilter

	@Autowired
	private MemberService service;
	private MemberDao dao;

	@RequestMapping("/memberList")
	public String MemberList(Model model) {

		System.out.println("memberList 요청");

		List<Member> list = service.selectAll();

		model.addAttribute("memberList", list);

		return "memberList";
	}

	

	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	

	@RequestMapping(value = "/join" ,method = RequestMethod.GET)
	public String joinForm() {
		return "join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST )
	public String join(HttpServletRequest request, Member member) {
		//회원가입 진행하기...
//		System.out.println("id : " + request.getParameter("id"));
//		System.out.println("pw : " + request.getParameter("pw"));
//		System.out.println("name : " + request.getParameter("name"));
//		System.out.println("email : " + request.getParameter("email"));

		
		if(service.join(member)) {
			//회원가입성공
			return "redirect:login";
		}else {
			return "redirect:join";
		}
		
	}
	
	
	@RequestMapping("/updateForm")
	public String updateForm(HttpSession session, Model model) {
		
		String id = (String)session.getAttribute("userid");
		
		model.addAttribute("member", service.getMemberById(id));
		
		return "memberUpdate";
	}
	
	@RequestMapping("/update")
	public String update() {
		return null;
	}

	@RequestMapping(value  = "/login" , method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	
	
	@RequestMapping(value = "/login", method =RequestMethod.POST)
	//public String login(@RequestParam Map<String, Object> params) 
	public String login(HttpSession session,Member member,RedirectAttributes ra){
		// login.jsp에서 넘겨주는 form 요소를 받아서
		// 로그인 진행
		System.out.println("userid :" + member.getId());
		System.out.println("userpw :" + member.getPw());
		
		
		/*System.out.println("userid :" + params.get("id") );
		System.out.println("userpw :" + params.get("pw") );*/
		
		
		boolean result 
		= service.login(member.getId(), member.getPw());
		
		if(result) {
			//세션에 아이디를 담고 메인으로 이동
			session.setAttribute("userid", member.getId());
			return "redirect:main";
		}else {
			//로그인 실패니까.. 로그인 페이지로 이동
			//로그인 페이지 이동할 때...실패 메시지를 전달하고 싶음
			
			
			//redirect할 때(새로운 요청을 만들어 낼 때) 메시지를 전달하려고 한다.
			//RedircetAttribute
			
			//model.addAttribute("msg", "로그인 실패"); 이렇게 못씀
			
			ra.addFlashAttribute("msg","로그인 실패");
			
			
			return "redirect:login";
		}
		
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("uesrid");
		
		return "redirect:login";
	}
	

}
