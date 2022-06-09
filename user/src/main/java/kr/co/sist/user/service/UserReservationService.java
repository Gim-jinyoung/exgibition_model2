package kr.co.sist.user.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.sist.user.dao.UserReservationDAO;
import kr.co.sist.user.vo.UserReservationVO;

public class UserReservationService {
	@Autowired(required = false)
	private UserReservationDAO urDAO;
	

	/**
	 * 날짜 출력
	 * @param ex_num
	 * @return
	 */
	public String searchDate(int ex_num){
		String deadline="";
		
		try {
			deadline=urDAO.selectDate(ex_num);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return deadline;
	}//searchDate
	
	/**
	 * 그 지역 전시 출력
	 * @param ex_loc
	 * @return
	 */
	public List<UserReservationVO> searchExhibition(String ex_loc){
		List<UserReservationVO> list=null;
		
		try {
			list=urDAO.selectExhibition(ex_loc);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return list;
	}//searchExhibition
	
	/**
	 * 지역리스트 출력
	 * @return
	 */
	public List<UserReservationVO> searchLocal(){
		List<UserReservationVO> list=null;
		
		try {
			list=urDAO.selectLocal();
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return list;
	}//searchLocal
	
	/**
	 * 전시 안내 출력
	 * @param ex_num
	 * @return
	 */
	public UserReservationVO searchExInfo(int ex_num){
		UserReservationVO urVO=new UserReservationVO();
		
		try {
			urVO=urDAO.selectExInfo(ex_num);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return urVO;
	}//searchExInfrom
	
	/**
	 * 예약
	 * @param urVO
	 * @return
	 */
	public int addRez(UserReservationVO urVO){
		int success=0;
		
		try {
			success=urDAO.insertRez(urVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return success;
	}//addRez
}//class
