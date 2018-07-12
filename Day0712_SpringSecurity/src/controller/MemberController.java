package controller;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.Member;
import service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberSerice;
	
	@RequestMapping("/memberList")
	public String memberList(Model model) {
		System.out.println("memberList 요청 받음");
		
		model.addAttribute("memberList", memberSerice.getAllMembers());
		return "memberList";
	}
	
//	@RequestMapping("/login")
//	public String login() {
//		//로그인 성공했을 때 진행되는 메서드...
//		System.out.println("로그인 성공, 진행");
//		return "redirect:main";
//	}
	
	@RequestMapping("/main")
	public String main() {
		System.out.println("main 진입!");
		return "main_user";
	}
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET )
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/join" ,method = RequestMethod.GET)
	public String joinForm() {
		return "join";
	}
	
	@RequestMapping("/updateForm")
	public String updateForm(HttpSession session,Model model) {
		String id = (String)session.getAttribute("userid");
		model.addAttribute("member", memberSerice.getMemberById(id));
		
		return "memberUpdate";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST )
	public String join(HttpServletRequest request,Member member) {
		return null;
	}
//	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("로그아웃 요청");
		memberSerice.logout(request, response);
		return "redirect:/loginForm?logout=true";
	}
	
	@RequestMapping("/update")
	public String update(Principal principal) {
		System.out.println(principal.getName());
		return "main";
	}
	
}
