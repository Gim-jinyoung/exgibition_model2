package kr.co.sist.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.sist.user.service.UserLoginService;
import kr.co.sist.user.vo.MemberVO;

@Controller
@SessionAttributes("loginUser")
public class UserLoginController {
	@Autowired(required = false)
	private UserLoginService userLoginService;
	
	//로그인
	@RequestMapping(value="/user/login.do",method= RequestMethod.POST)
	public String loginAction( MemberVO mVO,Model model) {
		MemberVO loginUser=userLoginService.Login(mVO);
		
		if(loginUser==null) {
		model.addAttribute("check",1);
		model.addAttribute("message","아이디와 비밀번호를 확인해주세요!");
		System.out.println("----------------실패-----------------"+loginUser);
		return "user/login";
		}else {
			model.addAttribute("loginUser",loginUser);
			System.out.println("----------------성공------------------"+loginUser);
			return "redirect:/user/user_index.do";
		}
	}
	@RequestMapping(value="/user/login.do",method=RequestMethod.GET)
	public void loginAction() {
		
	}
}
