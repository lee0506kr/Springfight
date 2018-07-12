package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import model.SMember;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	//Spring security 에서 사용자에 대한 권한을 제공하는 클래스 
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserDetailsService userDetailService;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
//		System.out.println("CustomAuthenticationProvider!!");
		
		//사용자가 입력한 비밀번호와 service가 가져다 준 사용자 정보의 비밀번호가 같으면 
		//권한 제공
		UsernamePasswordAuthenticationToken authToken = null;  
		
		//사용자가 입력한 이름 가져오기 
		String memberid = authentication.getName();
		String password = (String)authentication.getCredentials();
		UserDetails member = userDetailService.loadUserByUsername(memberid);
		if(member == null) {
//			System.out.println("사용자 없음!");
			throw new UsernameNotFoundException(memberid);
		}
		if(!passwordEncoder.matches(password, member.getPassword())) {
			System.out.println("password: " + password);
			System.out.println("member.getPassword(): " + member.getPassword());
			
//			System.out.println("비밀번호 일치 하지 않음");
			throw new BadCredentialsException("사용자가 없거나 비밀번호가 일치하지 않습니다.");
		}else {
			//비밀번호 일치
//			System.out.println("비번 일치!!");
//			System.out.println("member :  " + member.getAuthorities());
			authToken 
			= new UsernamePasswordAuthenticationToken(memberid,password,member.getAuthorities());
			System.out.println(authToken);
			return authToken;
		}
		
	}
	@Override
	public boolean supports(Class<?> arg0) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(arg0);
	}
}



















