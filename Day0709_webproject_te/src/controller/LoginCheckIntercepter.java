package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoginCheckIntercepter extends HandlerInterceptorAdapter{
	//요청처리전에 로그인이 되어있는지 아닌지 확인
	//요청 처리 후에는 아무 작업 X
	// : preHandler만 재정의
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		System.out.println("LoginCheckIntercepter : preHandle");
		//로그인이 되어있으면(session에 'userid') 속성이 있으면, 요청 진행
		//로그인 되어 있지 않으면( login 화면으로 이동)
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");
		if(userid == null) {
			//로그인되어 있지 않음, 요청 진행 중단.
			//로그인 화면으로 이동
			response.sendRedirect("boardList");
			return false;
		}else {
			//로그인 되어 있음, 
			return true; //요청 계속 진행
		}
	}
}





