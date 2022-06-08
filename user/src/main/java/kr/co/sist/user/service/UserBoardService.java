package kr.co.sist.user.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.sist.user.dao.UserBoardDAO;
import kr.co.sist.user.vo.UserBoardVO;


public class UserBoardService {
	@Autowired(required = false)
	private UserBoardDAO ubDAO;
	
	/**
	 * 카테고리에 따라 전체 게시글 리스트 출력
	 * @param ubVO 검색(아이디, 제목)
	 * @return
	 */
	public List<UserBoardVO> searchBoard(UserBoardVO ubVO){
		List<UserBoardVO> list=null;
		
		try {
			list=ubDAO.selectBoard(ubVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return list;
	}//allBoard
	
	
	/** 
	 * 페이징 처리를 위한 전체 게시글 갯수 얻기
	 * @param cat_num 카테고리 번호
	 * @return 전체 게시글 수
	 */
	public void searchTotalCount(int cat_num) {
		int cnt=0;
		
		try {
			cnt=ubDAO.selectTotalCount( cat_num );
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		UserBoardVO ubVO=new UserBoardVO();
		ubVO.setTotalCnt(cnt);
	}//searchTotalCount
	
	/**
	 * 한 페이지당 보여줄 게시글 수
	 * @return 10개
	 */
	public void pageScale() {
		UserBoardVO ubVO=new UserBoardVO();
		ubVO.setPageScale(10);
	}//pageScale
	

	/**
	 * 전체 게시글을 10개씩 나눴을 때 필요한 페이지 수
	 * @param totalCnt 전체 게시글 수
	 * @param pageScale 10개
	 * @return 필요한 페이지 수
	 */
	public void pageCnt(UserBoardVO ubVO) {
		int pageCnt=0;
		pageCnt=(int)Math.ceil((double)ubVO.getTotalCnt()/ubVO.getPageScale());
		ubVO.setPageCnt(pageCnt);
	}//end pageCnt
	
	
	/**
	 * 페이지 첫 게시글 번호 얻기
	 * @param currentPage 현재 페이지 번호
	 * @param pageScale 10개
	 * @return 
	 */
	public void startNum(UserBoardVO ubVO) {
		int startNum=1;
		
		startNum=ubVO.getCurrentPage()*ubVO.getPageScale()-ubVO.getPageScale()+1;
		ubVO.setStartNum(startNum);
	}//startNum
	
	
	/**
	 * 페이지 마지막 게시글 번호 얻기
	 * @param startNum 페이지 첫번째 게시글 번호
	 * @param pageScale 10개
	 * @return 마지막 게시글 번호
	 */
	public void endNum(UserBoardVO ubVO) {
		int endNum=0;
		endNum=ubVO.getStartNum()+ubVO.getPageScale()-1;
		ubVO.setEndNum(endNum);
	}//endNum
	
	/**
	 * 게시글 삭제
	 * @param bd_id
	 * @return 삭제 성공 여부
	 */
	public int removeBoard(int bd_id) {
		int success=0;
		
		try {
			success=ubDAO.deleteBoard( bd_id );
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return success;
	}//removeBoard
	
	/**
	 * 게시글 추가
	 * @param ubVO
	 */
	public void addBoard(UserBoardVO ubVO) {
		
		try {
			ubDAO.insertBoard( ubVO );
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
	}//addBoard
	
	/**
	 * 게시글 수정
	 * @param ubVO
	 * @return 성공 여부
	 */
	public int modifyBoard(UserBoardVO ubVO) {
		int success=0;
		
		try {
			success=ubDAO.updateBoard( ubVO );
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return success;
	}//addBoard
	
	/**
	 * 게시글 상세
	 * @param bd_id
	 * @return
	 */
	public UserBoardVO boardDetail(int bd_id) {
		UserBoardVO ubVO=new UserBoardVO();
		
		try {
			ubVO=ubDAO.selectBoardDetail( bd_id );
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return ubVO;
	}//boardDetail
	
	/**
	 * 카테고리 보여주기
	 * @return
	 */
	public List<UserBoardVO> category() {
		List<UserBoardVO> list=null;
		try {
			list=ubDAO.selectCat();
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return list;
	}//category
	
	/**
	 * 뷰 수 수정
	 * @param bd_id
	 */
	public void modifyView(int bd_id) {
		try {
			ubDAO.updateView(bd_id);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
	}//modifyView
	
	/**
	 * 댓글 보여주기
	 * @param bd_id
	 * @return
	 */
	public List<UserBoardVO> comment (int bd_id) {
		List<UserBoardVO> list= null;
		
		try {
			list=ubDAO.selectCom(bd_id);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return list;
	}//comment
	
	/**
	 * 댓글 삭제
	 * @param cm_id
	 * @return
	 */
	public int removeCom (int cm_id) {
		int success=0;
		
		try {
			success=ubDAO.deleteCom(cm_id);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return success;
	}//removeCom
	
	/**
	 * 댓글 추가
	 * @param ubVO
	 * @return
	 */
	public int addCom (UserBoardVO ubVO) {
		int success=0;
		
		try {
			success=ubDAO.insertCom(ubVO);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return success;
	}//addCom
	
}//class
