package kr.co.sist.user.service;

import kr.co.sist.user.vo.MemberVO;

public interface UserJoinService {
	//ȸ������
	public void UserJoin(MemberVO mVO)throws Exception;
	//�α���
	public MemberVO Iogin(MemberVO mVO)throws Exception;
}
