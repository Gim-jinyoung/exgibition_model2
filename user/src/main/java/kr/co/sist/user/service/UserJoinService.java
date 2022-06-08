package kr.co.sist.user.service;

import kr.co.sist.user.vo.MemberVO;

public interface UserJoinService {
	//회원가입
	public void UserJoin(MemberVO mVO)throws Exception;
	//로그인
	public MemberVO Iogin(MemberVO mVO)throws Exception;
}
