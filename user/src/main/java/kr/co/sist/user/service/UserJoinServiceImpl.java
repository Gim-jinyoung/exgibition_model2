package kr.co.sist.user.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.user.dao.UserJoinDAO;
import kr.co.sist.user.vo.MemberVO;

@Service
public class UserJoinServiceImpl implements UserJoinService {
@Autowired(required = false)
 UserJoinDAO ujDAO;
	
	@Override
	public void UserJoin(MemberVO mVO)throws Exception{
		ujDAO.UserJoin(mVO);//회원가입
	}
	public MemberVO Iogin(MemberVO mVO)throws Exception{
		return ujDAO.Iogin(mVO);//로그인
	}
}
