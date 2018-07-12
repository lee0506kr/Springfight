package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HttpServletBean;

import model.Member;

public interface MemberService {
	public List<Member> getAllMembers();
	public boolean login(String id,String pw);
	public Member getMemberById(String id);
	public void logout(HttpServletRequest request,HttpServletResponse response);
	
	
	
}
