package kr.co.sist.user.service;

import kr.co.sist.user.vo.MemberVO;

public interface UserJoinService {
	void joinUser(MemberVO mVO);
	
	MemberVO idCheck(String userId);
}
