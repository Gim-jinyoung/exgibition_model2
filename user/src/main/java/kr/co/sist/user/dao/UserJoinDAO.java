package kr.co.sist.user.dao;


import kr.co.sist.user.vo.MemberVO;

public interface UserJoinDAO {
	//ȸ������
	public void UserJoin(MemberVO mVO)throws Exception;
	//�α���
	public MemberVO Iogin(MemberVO mVO)throws Exception;
}
