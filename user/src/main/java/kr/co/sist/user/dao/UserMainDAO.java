package kr.co.sist.user.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.user.mybatis.MyBatisFramework;
import kr.co.sist.user.vo.UserExhibitionHallVO;
import kr.co.sist.user.vo.UserExhibitionVO;

@Component
public class UserMainDAO {

	public List<UserExhibitionVO> selectExRepresent()throws PersistenceException {
		List<UserExhibitionVO> list=null;
		
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		list=ss.selectList("kr.co.sist.user.dao.usermain.selectExRepresent");
		return list;
	}
	
	public List<UserExhibitionHallVO> selectExLocAll()throws PersistenceException {
		List<UserExhibitionHallVO> list=null;
		
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		list=ss.selectList("kr.co.sist.user.dao.usermain.selectExLocAll");
		return list;
	}
	
	public List<UserExhibitionVO> viewExList()throws PersistenceException {
		List<UserExhibitionVO> list=null;
		
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		list=ss.selectList("kr.co.sist.user.dao.usermain.viewExList");
		return list;
	}
}
