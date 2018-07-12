package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import dao.AuthorityDao;
import dao.MemberDao;
import model.Member;
import model.Role;
import model.SMember;

@Component
public class CustomUserDetailService implements UserDetailsService {
	
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private AuthorityDao authDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String memberid) throws UsernameNotFoundException {
//		System.out.println("CustomUserDetailService!!");
		
		//사용자의 권한 가져오거나 권한 부여  
		//UserDetails 사용자의 권한을 가지고 있는 클래스의 인터페이스  
		
		//현재 로그인 하려는 사용자의 정보를 db에서 얻어오고 정보를 이용해서 
		//UserDetails를 만들어냄...
		//권한 저장 클래스
		SMember smember = null;

		//실제 db에 저장된 사용자 정보
		Member member = memberDao.selectOne(memberid);
		
		//db에 아이디가 존재하면  ROLE_USER 권한 부여 		
		if(member != null) {
			 smember = new SMember();
			smember.setPassword(member.getPw());
			smember.setUsername(member.getId());
			
//			사용자 이름으로 auth table가서 권한 조회
			List<String> authities 
			 = authDao.selectUserAuthorities(memberid);
			for(String auth:authities) {
				smember.addAuthority(new Role(auth));
			}
			
//			smember.addAuthority(new Role("ROLE_USER"));
		}
		return smember;
	}
	
}
