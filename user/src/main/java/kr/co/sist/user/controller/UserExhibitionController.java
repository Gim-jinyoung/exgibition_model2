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
	//전시 리스트
	
	@RequestMapping(value="/user/list.do",method = GET)
	public String exListView(Model model,@RequestParam(defaultValue ="0") int ex_hall_num) {
		model.addAttribute("exListView",us.exListAllView());
		if(ex_hall_num!=0) {
			model.addAttribute("exListView",us.exListView(ex_hall_num));
		}		
		return "user/list";
	}
	
	//지역별 검색
	@RequestMapping(value="/user/loc.do",method = GET)
	public String searchLocEx(Model model) {
		
		model.addAttribute("searchLocEx",us.searchLocEx());
		
		return "user/loc";
	}
	
}
