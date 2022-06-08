package kr.co.sist.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.user.service.UserExhibitionService;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class UserExhibitionController {
	
	@Autowired(required = false)
	private UserExhibitionService us;
	//���� ����Ʈ
	
	@RequestMapping(value="/user/list.do",method = GET)
	public String exListView(Model model, String ex_name) {
		model.addAttribute("exListView",us.exListAllView());
		if(ex_name!=null) {
			model.addAttribute("exListView",us.exListView(ex_name));
		}		
		return "user/list";
	}
	
	//������ �˻�
	@RequestMapping(value="/user/loc.do",method = GET)
	public String searchLocEx(Model model) {
		
		model.addAttribute("searchLocEx",us.searchLocEx());
		
		return "user/loc";
	}
	
}
