package kr.co.sist.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sist.user.mybatis.MyBatisFramework;
import kr.co.sist.user.vo.MemberVO;

@Repository
public class LoginDAO {
public MemberVO Login(MemberVO mVO) {
	SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
	
	System.out.println("----MyBatis 로그인 기능-----");
	return ss.selectOne("kr.co.sist.user.login",mVO);
	
	
}
}
