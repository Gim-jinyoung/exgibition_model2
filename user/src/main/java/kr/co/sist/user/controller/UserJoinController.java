package kr.co.sist.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.exceptions.PersistenceException;
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
public class UserJoinController {
	private static final Logger Logger = LoggerFactory.getLogger(UserJoinController.class);
	
	@Autowired(required = false)
	UserJoinService ujService;
	
	//약관
	@RequestMapping(value="/user/terms.do",method=RequestMethod.GET)
	public void JoinRequire() {
		
	}
	//회원가입 get
	@RequestMapping(value ="/user/register.do",method =RequestMethod.GET)
	public void getJoin()throws Exception{
		Logger.info("get Join");
	}
	//회원가입 Post
	@RequestMapping(value ="/user/register.do",method = RequestMethod.POST)
	public String postJoin(MemberVO mVO)throws PersistenceException{
		
		ujService.joinUser(mVO);
		
		return "user/registerSucess";
		
		
	}
	
	
	
}
