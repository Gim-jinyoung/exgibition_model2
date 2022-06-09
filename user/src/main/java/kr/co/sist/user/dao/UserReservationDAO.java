package kr.co.sist.user.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.user.mybatis.MyBatisFramework;
import kr.co.sist.user.vo.UserReservationVO;

public class UserReservationDAO {
	
	/**
	 * 날짜 출력
	 * @param ex_num
	 * @return
	 * @throws PersistenceException
	 */
	public String selectDate(int ex_num) throws PersistenceException{
		String deadline="";
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		deadline=ss.selectOne("kr.co.sist.user.userRez.selectDate");
		if(ss != null) {
			ss.close();
		}//end if
		
		return deadline;
	}//selectDate
	
	/**
	 * 그 지역 전시 보여주기
	 * @param ex_loc 
	 * @return
	 * @throws PersistenceException
	 */
	public List<UserReservationVO> selectExhibition(String ex_loc) throws PersistenceException{
		List<UserReservationVO> list=null;
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		list=ss.selectList("kr.co.sist.user.userRez.selectExhibition");
		if(ss != null) {
			ss.close();
		}//end if
		
		return list;
	}//selectDate
	
	/**
	 * 지역 리스트 출력
	 * @return
	 * @throws PersistenceException
	 */
	public List<UserReservationVO> selectLocal() throws PersistenceException{
		List<UserReservationVO> list=null;
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		list=ss.selectList("kr.co.sist.user.userRez.selectLocal");
		if(ss != null) {
			ss.close();
		}//end if
		
		return list;
	}//selectLocal
	
	/**
	 * 전시 안내 출력
	 * @param ex_num
	 * @return
	 * @throws PersistenceException
	 */
	public UserReservationVO selectExInfo(int ex_num) throws PersistenceException{
		UserReservationVO urVO=new UserReservationVO();
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		urVO=ss.selectOne("kr.co.sist.user.userRez.selectExInfo");
		if(ss != null) {
			ss.close();
		}//end if
		
		return urVO;
	}//selectExInfo
	
	/**
	 * 예약 
	 * @param urVO
	 * @return
	 * @throws PersistenceException
	 */
	public int insertRez(UserReservationVO urVO) throws PersistenceException{
		int success=0;
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		success=ss.selectOne("kr.co.sist.user.userRez.reservation");
		if(ss != null) {
			ss.close();
		}//end if
		
		return success;
	}//insertRez


}//class
