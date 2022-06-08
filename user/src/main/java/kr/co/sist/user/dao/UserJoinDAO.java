package kr.co.sist.user.dao;


import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sist.user.mybatis.MyBatisFramework;
import kr.co.sist.user.vo.MemberVO;
@Repository
public class UserJoinDAO {
	
	
	public void joinUser(MemberVO mVO) {
		System.out.println("--MyBatis�� ȸ������ ��� ó��");
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		ss.insert("kr.co.sist.user.memberInsert",mVO);
		ss.commit();
	}
	public MemberVO idCheck(String userId) {
		System.out.println("--���̵�Ȯ�� ���ó��");
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		MemberVO member=ss.selectOne("kr.co.sist.user.idCheck",userId);
		
		return member;
	}
}
