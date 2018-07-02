package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import aj.org.objectweb.asm.Handle;

@Component
public class SampleInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			//요청을 처리하고 난 후 실행
			System.out.println("Post Handle....");
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			//요청을 처리하기 전 실행
			//반환값  true : 요청을 계속 진행
		    //     false:  요청 처리 중단
			System.out.println("Pre Handle....");
		return true;
	}
	//인터셉터 동작을 확인하기 위한 클래스 
	
	
}




