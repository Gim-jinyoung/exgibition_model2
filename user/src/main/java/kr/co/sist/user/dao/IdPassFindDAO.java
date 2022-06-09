package kr.co.sist.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sist.user.mybatis.MyBatisFramework;
import kr.co.sist.user.vo.MemberVO;

@Repository
public class IdPassFindDAO {
	
	//아이디찾기
	public MemberVO findId(MemberVO mVO) {
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		return ss.selectOne("kr.co.sist.user.findId",mVO);
	}
	//비밀번호찾기
	public MemberVO findPassword(MemberVO mVO) {
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		return ss.selectOne("kr.co.sist.user.findPassword",mVO);
	}
}
