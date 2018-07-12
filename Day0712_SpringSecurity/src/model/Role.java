package model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.filter.DelegatingFilterProxy;


public class Role implements GrantedAuthority{
	//권한 정보를 가지고 있는 클래스
	private static final long serialVersionUID = -8846719920622457364L;
	
	private String authority;
	
	public Role() {}
	public Role(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}
	
	@Override
	public String toString() {
		return "Role [authority=" + authority + "]";
	}
	
}
