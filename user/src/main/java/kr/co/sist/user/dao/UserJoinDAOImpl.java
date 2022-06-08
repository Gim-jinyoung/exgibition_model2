package kr.co.sist.user.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.sist.user.vo.MemberVO;

@Repository
public class UserJoinDAOImpl implements UserJoinDAO {
	@Autowired(required = false) 
	SqlSession sql;
	//회원가입
	
	@Override
	public void UserJoin(MemberVO mVO)throws Exception{
		sql.insert("kr.co.sist.user.memberInsert",mVO);
	}
	public MemberVO Iogin(MemberVO mVO)throws Exception{
		return sql.selectOne("kr.co.sist.user.login",mVO);
	}
}
