package kr.co.sist.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sist.user.mybatis.MyBatisFramework;
import kr.co.sist.user.vo.MemberVO;

@Repository
public class IdPassFindDAO {
	
	//���̵�ã��
	public MemberVO findId(MemberVO mVO) {
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		return ss.selectOne("kr.co.sist.user.findId",mVO);
	}
	//��й�ȣã��
	public MemberVO findPassword(MemberVO mVO) {
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		return ss.selectOne("kr.co.sist.user.findPassword",mVO);
	}
}
