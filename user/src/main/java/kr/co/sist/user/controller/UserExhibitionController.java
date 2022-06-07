package kr.co.sist.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.service.UserExhibitionService;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class UserExhibitionController {
	
	@Autowired(required = false)
	private UserExhibitionService us;
	
	@RequestMapping(value="/user/list.do",method = GET)
	public String exListView(Model model,String ex_name) {
		
		
		return "user/list";
	}
	
}
