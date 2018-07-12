package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping(value = "/",method=RequestMethod.GET)
	public String index() {
		return "login";
	}
	
	@RequestMapping(value = "/loginForm",method=RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping("/noAuth")
	public String noAuth() {
		return "noAuth";
	}
}
