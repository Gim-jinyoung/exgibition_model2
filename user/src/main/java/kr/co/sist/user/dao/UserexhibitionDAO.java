package kr.co.sist.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.user.mybatis.MyBatisFramework;
import kr.co.sist.user.vo.UserExhibitionVO;

@Component
public class UserexhibitionDAO {

	public List<UserExhibitionVO> selectAllExList(String ex_name){
		List<UserExhibitionVO> list=null;
		
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		list=ss.selectList("kr.co.sist.user.dao.userexlist.selectAllExList",ex_name);
		
		if(ss!=null ) {ss.close();}
		return list;
	}
	
	public List<UserExhibitionVO> selectLocalExList(String ex_name){
		List<UserExhibitionVO> list=null;
		
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		list=ss.selectList("kr.co.sist.user.dao.userexlist.selectLocalExList",ex_name);
		
		if(ss!=null ) {ss.close();}
		return list;
	}
}
