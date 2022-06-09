package kr.co.sist.user.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.user.mybatis.MyBatisFramework;
import kr.co.sist.user.vo.UserExhibitionHallVO;
import kr.co.sist.user.vo.UserExhibitionVO;

@Component
public class UserexhibitionDAO {

	public List<UserExhibitionVO> selectAllExList(int ex_hall_num)throws PersistenceException{
		List<UserExhibitionVO> list=null;
		
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		list=ss.selectList("kr.co.sist.user.dao.userexlist.selectAllExList",ex_hall_num);
		
		if(ss!=null ) {ss.close();}
		return list;
	}
	public List<UserExhibitionVO> exListAllView()throws PersistenceException{
		List<UserExhibitionVO> list=null;
		
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		list=ss.selectList("kr.co.sist.user.dao.userexlist.selectAllExList");
		
		if(ss!=null ) {ss.close();}
		return list;
	}
	
	public List<UserExhibitionHallVO> selectLocalExList()throws PersistenceException{
		List<UserExhibitionHallVO> list=null;
		
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		list=ss.selectList("kr.co.sist.user.dao.userexlist.selectLocalExList");
		
		if(ss!=null ) {ss.close();}
		return list;
	}
}
