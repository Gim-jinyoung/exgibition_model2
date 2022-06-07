package kr.co.sist.user.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.UserExhibitionDetailDAO;
import kr.co.sist.user.vo.UserBoardVO;
import kr.co.sist.user.vo.UserExhibitionHallVO;
import kr.co.sist.user.vo.UserExhibitionVO;

@Component
public class UserExhibitionDetailService {

		@Autowired(required = false)
		private UserExhibitionDetailDAO uedDAO;
		
		public UserExhibitionVO exhibitionView(int ex_num) {
			UserExhibitionVO ue=null;
			try {
				ue=uedDAO.selectExhibition(ex_num);
			} catch (PersistenceException pe) {
				pe.printStackTrace();
			}
			return ue;
		}
		public List<UserBoardVO> relBoard(int cat_num) {
			List<UserBoardVO> list=null;
			
			try {
				list=uedDAO.selectRelBoard(cat_num);
			} catch (PersistenceException pe) {
				pe.printStackTrace();
			}
			return list;
		}
		
		public UserExhibitionHallVO mapView(UserExhibitionHallVO uehVO) {
			UserExhibitionHallVO ueh=null;
			
			try {
				ueh=uedDAO.mapSelect(ueh);
			} catch (PersistenceException pe) {
				pe.printStackTrace();
			}
			return ueh;
		}
}
