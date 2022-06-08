package kr.co.sist.user.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.tree.ExpandVetoException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.sist.user.service.UserJoinService;
import kr.co.sist.user.vo.MemberVO;
@Controller
@RequestMapping("/user/join.do")
public class UserJoinController {
	private static final Logger Logger = LoggerFactory.getLogger(UserJoinController.class);
	
	@Autowired(required = false)
	UserJoinService ujService;
	
	//회원가입 get
	@RequestMapping(value ="/user/sist/join.do",method =RequestMethod.GET)
	public void getJoin()throws Exception{
		Logger.info("get Join");
	}
	//회원가입 Post
	@RequestMapping(value ="/user/sist/join.do",method = RequestMethod.POST)
	public void postJoin(MemberVO mVO)throws Exception{
		Logger.info("post Info");
		
		ujService.UserJoin(mVO);
	}
	//로그인
	@RequestMapping(value="/user/sist/login.do",method=RequestMethod.POST)
	public String Iogin(MemberVO mVO,HttpServletRequest req,RedirectAttributes rttr)throws Exception{
		Logger.info("post login");
		HttpSession session=req.getSession();
		MemberVO login = ujService.Iogin(mVO);
		if(login==null) {
			session.setAttribute("member",null);
			rttr.addFlashAttribute("msg",false);
		}else {
			session.setAttribute("member", login);
		}
		return "redirect:/user/sist/login";
	}
	
	
}
