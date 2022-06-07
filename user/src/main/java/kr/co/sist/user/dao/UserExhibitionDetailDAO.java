package kr.co.sist.user.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.user.mybatis.MyBatisFramework;
import kr.co.sist.user.vo.UserBoardVO;
import kr.co.sist.user.vo.UserExhibitionHallVO;
import kr.co.sist.user.vo.UserExhibitionVO;

@Component
public class UserExhibitionDetailDAO {

		public UserExhibitionVO selectExhibition(int ex_num) throws PersistenceException{
			UserExhibitionVO ue=null;
			
			SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
			ue=ss.selectOne("kr.co.sist.user.dao.exdetail.selectExhibition",ex_num);
			if(ss!=null) {ss.close();}
			
			return  ue;
		}
		
		public List<UserBoardVO> selectRelBoard(int cat_num){
			List<UserBoardVO> list=null;
			
			SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
			list=ss.selectList("kr.co.sist.user.dao.exdetail.selectRelBoard");
			
			if(ss!=null) {ss.close();}
			
			return list;
		}
		
		public UserExhibitionHallVO mapSelect(UserExhibitionHallVO exVO) {
			UserExhibitionHallVO ueh=null;
			
			SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
			ueh=ss.selectOne("kr.co.sist.user.dao.exdetail.mapSelect",exVO);
			
			if(ss!=null) {ss.close();}
			return ueh;
		}
}
