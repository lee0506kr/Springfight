package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BoardDao;
import dao.MemberDao;
import model.Member;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public List<Member> getAllMembers() {
		return memberDao.selectAll();
	}

	@Override
	public boolean login(String id, String pw) {
		// TODO Auto-generated method stub
		
		Member member = memberDao.selectOne(id);
		
		if(member != null) {
			//아이디 있음
			if(member.getPw().equals(pw)) {
				return true;
			}else {
				return false;
			}
		}else {
			//아이디 없음 : 로그인 실패 
			return false;
		}
	}

	@Override
	public Member getMemberById(String id) {
		return memberDao.selectOne(id);
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		//로그인 처리(권한과, userid등을 session 에 저장)를 spring이 처리
		//로그아웃도 spring 에게 위임
		Authentication auth 
		 = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler()
			.logout(request, response, auth);
		}
	}
	
	
	
	
	
	
	
	
	
}
