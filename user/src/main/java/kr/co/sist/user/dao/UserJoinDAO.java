package kr.co.sist.user.dao;


import kr.co.sist.user.vo.MemberVO;

public interface UserJoinDAO {
	//회원가입
	public void UserJoin(MemberVO mVO)throws Exception;
	//로그인
	public MemberVO Iogin(MemberVO mVO)throws Exception;
}
