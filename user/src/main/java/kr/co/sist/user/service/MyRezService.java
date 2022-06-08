package kr.co.sist.user.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.sist.user.dao.MyReservationDAO;
import kr.co.sist.user.vo.MyReservationVO;

public class MyRezService {
	
	@Autowired(required = false)
	private MyReservationDAO mrDAO;
	

	/**
	 * 내 예약 리스트 출력
	 * @param userid
	 * @return
	 */
	public List<MyReservationVO> searchRez(String userid){
		List<MyReservationVO> list=null;
		
		try {
			list=mrDAO.selectAllRez(userid);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return list;
	}//allBoard
	
	/**
	 * 예약 상세 보여주기
	 * @param mrVO
	 * @return
	 */
	public MyReservationVO searchRezDetail(MyReservationVO mrVO){
		
		try {
			mrVO=mrDAO.selectRezDtail(mrVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return mrVO;
	}//searchRezDetail
	
	/**
	 * 예약 취소
	 * @param mrVO
	 * @return
	 */
	public int rezCancle(MyReservationVO mrVO){
		int success=0;
		
		try {
			success=mrDAO.updateRez(mrVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return success;
	}//rezCancle
}//class
