package kr.co.sist.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import kr.co.sist.user.service.UserMainService;

@Controller
public class UserMainController {
	
	@Autowired(required = false)
	private UserMainService us;
	
	@RequestMapping(value="/user/user_index.do", method = GET)
	public String userMain(Model model) {
	
		model.addAttribute("exView",us.mainExView());
		model.addAttribute("locView",us.locView());
		model.addAttribute("listView",us.listView());
		
		return "user/index";
	}
}
