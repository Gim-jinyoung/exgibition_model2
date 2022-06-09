package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.user.service.UserReservationService;
import kr.co.sist.user.vo.UserReservationVO;

@Controller
public class UserReservationController {

	@Autowired(required = false)
	private UserReservationService urs;
	
	
	@RequestMapping(value="/user/exInfo.do", method=GET)
	public String exInfo(Model model,@RequestParam(defaultValue ="1" ) int ex_num) {
		
		//날짜 출력
		model.addAttribute("deadline",urs.searchDate(ex_num));
		model.addAttribute("exInfo",urs.searchExInfo(ex_num));
		
		return "user/exInfo";
	}//exInfo
	
	/**
	 * 전시 보여주기
	 * @param model
	 * @param ex_loc
	 * @return
	 */
	@RequestMapping(value="/user/ex.do", method=GET)
	public String ex(Model model,@RequestParam(defaultValue = "서울") String ex_loc) {
		
		model.addAttribute("exList",urs.searchExhibition(ex_loc));
		
		return "user/ex";
	}//ex
	
	/**
	 * 지역 리스트 출력
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/user/local.do", method=GET)
	public String local(Model model) {
		
		model.addAttribute("localList",urs.searchLocal());
		
		return "user/local";
	}//local
	
	@RequestMapping(value="/user/reservation.do", method=POST)
	public String Reservation(UserReservationVO urVO, HttpSession session) {
		
		urVO.setUserid(session.getId());
		urs.addRez(urVO);
		
		return "user/reservation";
	}//Reservation
}//class
