package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.user.service.UserBoardService;
import kr.co.sist.user.vo.UserBoardVO;;

@Controller
public class UserBoardController {
	@Autowired(required = false)
	private UserBoardService ubs;
	
	@RequestMapping(value={"/user/catBoard.do", "/index.do"}, method=GET)
	public String searchBoard(Model model, UserBoardVO ubVO) { 
	  
		ubs.pageScale();
		ubs.pageCnt(ubVO);
		ubs.startNum(ubVO);
		ubs.endNum(ubVO);
		 
		if(ubVO.getCat_num() != 0) {
			ubVO.setCat_num(1);
		}//end if
		
		model.addAttribute("boardList",ubs.searchBoard(ubVO));
		model.addAttribute("totalCnt",ubVO.getTotalCnt());
		model.addAttribute("pageScale",ubVO.getPageScale() );
		model.addAttribute("pageCnt",ubVO.getPageCnt() );
		model.addAttribute("startNum",ubVO.getStartNum() ); 
		model.addAttribute("endNum",ubVO.getEndNum() ); 
		model.addAttribute("currentPage",ubVO.getCurrentPage());
		  
		return "user/board";
	  }//searchBoard
	
	/**
	 * 게시글 삭제
	 * @param model 삭제 완료 알림
	 * @param session 글 아이디와 삭제하려는 아이디 대조
	 * @param bd_id
	 * @return
	 */
	@RequestMapping(value="/user/deleteBoard.do", method=POST)
	public String deleteBoard(Model model,HttpSession session,@RequestParam(defaultValue = "0") int bd_id) {
		
		UserBoardVO ubVO=new UserBoardVO();
		int success=0;
		
		if(bd_id != 0 && session.getId() == ubVO.getUserid()) {
			model.addAttribute("removeResult",ubs.removeBoard(bd_id));
		}//end if
		
		return "user/deleteBoard";
	}//deleteBoard
	
	/**
	 * 게시글 추가
	 * @param ubVO
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/user/addBoard.do", method=POST)
	public String addBoard(UserBoardVO ubVO, HttpSession session) {
		
		ubVO.setUserid(session.getId());
		ubs.addBoard(ubVO);
		
		return "user/addBoard";
	}//deleteBoard
	
	/**
	 * 게시글 추가 폼
	 * @return
	 */
	@RequestMapping(value="/user/boardForm.do", method=GET)
	public String addBoardForm() {
		return "user/addBoard";
	}//addBoardForm
	
	/**
	 * 게시글 상세보기, 댓글 리스트 출력
	 * @param model
	 * @param bd_id
	 * @return
	 */
	@RequestMapping(value="/user/boardDetail.do", method=GET)
	public String boardDetail(Model model,@RequestParam(defaultValue = "0") int bd_id) {
		
		//게시글 클릭 시 view 수 수정
		ubs.modifyView(bd_id);
		
		if(bd_id != 0) {
			model.addAttribute("detailData",ubs.boardDetail(bd_id));
			model.addAttribute("comList",ubs.comment(bd_id));
		}//end if
		
		return "user/boardDetail";
	}//boardDetail

	
	/**
	 * 게시글 수정
	 * @param model 성공여부
	 * @param ubVO 
	 * @param session 작성자와 수정하려는 자 아이디 대조
	 * @return
	 */
	@RequestMapping(value="/user/modifyBoard.do", method=POST)
	public String modifyBoard(Model model, UserBoardVO ubVO, HttpSession session) {
		
		if(ubVO.getUserid() == session.getId()) {
			model.addAttribute("modifyResult",ubs.modifyBoard(ubVO));
		}//end if
		
		return "user/modifyBoard";
	}//modifyBoard
	
	/**
	 * 카테고리 출력
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/user/category.do", method=GET)
	public String searchCat(Model model) {
		
		model.addAttribute("catList",ubs.category());
		
		return "user/category";
	}//searchCat
	
	/**
	 * 댓글 삭제
	 * @param model 삭제 완료
	 * @param cm_id 삭제할 댓글
	 * @param session 댓글 쓴 사용자와 현재 접속 중 사용자가 같을 경우
	 * @return
	 */
	@RequestMapping(value="/user/deleteComm.do", method=POST)
	public String removeCom(Model model,@RequestParam(defaultValue = "0") int cm_id, HttpSession session) {
		
		UserBoardVO ubVO=new UserBoardVO();
		
		if(cm_id != 0 && session.getId() == ubVO.getCm_userid()) {
			model.addAttribute("deleteComResult",ubs.removeCom(cm_id));	
		}//end if
		
		return "user/deleteComm";
	}//removeCom
	
	@RequestMapping(value="/user/insertComm.do", method=POST)
	public String addCom(Model model,UserBoardVO ubVO, HttpSession session) {
		
			ubVO.setUserid(session.getId());
			model.addAttribute("deleteComResult",ubs.addCom(ubVO));	
		
		return "user/insertComm";
	}//addCom
	
	
	
	
	
	
}//class
