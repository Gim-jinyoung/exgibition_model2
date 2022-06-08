//package kr.co.sist.user.controller;
//
//import static org.springframework.web.bind.annotation.RequestMethod.GET;
//import static org.springframework.web.bind.annotation.RequestMethod.POST;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import kr.co.sist.user.service.UserBoardService;
//import kr.co.sist.user.vo.UserBoardVO;;
//
//@Controller
//public class UserBoardController {
//	@Autowired(required = false)
//	private UserBoardService ubs;
//	
//	@RequestMapping(value={"/user/catBoard.do", "/index.do"}, method=GET)
//	public String searchBoard(Model model, UserBoardVO ubVO) { 
//	  
//		ubs.pageScale();
//		ubs.pageCnt(ubVO);
//		ubs.startNum(ubVO);
//		ubs.endNum(ubVO);
//		 
//		if(ubVO.getCat_num() != 0) {
//			ubVO.setCat_num(1);
//		}//end if
//		
//		model.addAttribute("boardList",ubs.searchBoard(ubVO));
//		model.addAttribute("totalCnt",ubVO.getTotalCnt());
//		model.addAttribute("pageScale",ubVO.getPageScale() );
//		model.addAttribute("pageCnt",ubVO.getPageCnt() );
//		model.addAttribute("startNum",ubVO.getStartNum() ); 
//		model.addAttribute("endNum",ubVO.getEndNum() ); 
//		model.addAttribute("currentPage",ubVO.getCurrentPage());
//		  
//		return "user/board";
//	  }//searchBoard
//	
//	/**
//	 * 寃뚯떆湲� �궘�젣
//	 * @param model �궘�젣 �셿猷� �븣由�
//	 * @param session 湲� �븘�씠�뵒�� �궘�젣�븯�젮�뒗 �븘�씠�뵒 ��議�
//	 * @param bd_id
//	 * @return
//	 */
//	@RequestMapping(value="/user/deleteBoard.do", method=POST)
//	public String deleteBoard(Model model,HttpSession session,@RequestParam(defaultValue = "0") int bd_id) {
//		
//		UserBoardVO ubVO=new UserBoardVO();
//		int success=0;
//		
//		if(bd_id != 0 && session.getId() == ubVO.getUserid()) {
//			model.addAttribute("removeResult",ubs.removeBoard(bd_id));
//		}//end if
//		
//		return "user/deleteBoard";
//	}//deleteBoard
//	
//	/**
//	 * 寃뚯떆湲� 異붽�
//	 * @param ubVO
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping(value="/user/addBoard.do", method=POST)
//	public String addBoard(UserBoardVO ubVO, HttpSession session) {
//		
//		ubVO.setUserid(session.getId());
//		ubs.addBoard(ubVO);
//		
//		return "user/addBoard";
//	}//deleteBoard
//	
//	/**
//	 * 寃뚯떆湲� 異붽� �뤌
//	 * @return
//	 */
//	@RequestMapping(value="/user/boardForm.do", method=GET)
//	public String addBoardForm() {
//		return "user/addBoard";
//	}//addBoardForm
//	
//	/**
//	 * 寃뚯떆湲� �긽�꽭蹂닿린, �뙎湲� 由ъ뒪�듃 異쒕젰
//	 * @param model
//	 * @param bd_id
//	 * @return
//	 */
//	@RequestMapping(value="/user/boardDetail.do", method=GET)
//	public String boardDetail(Model model,@RequestParam(defaultValue = "0") int bd_id) {
//		
//		//寃뚯떆湲� �겢由� �떆 view �닔 �닔�젙
//		ubs.modifyView(bd_id);
//		
//		if(bd_id != 0) {
//			model.addAttribute("detailData",ubs.boardDetail(bd_id));
//			model.addAttribute("comList",ubs.comment(bd_id));
//		}//end if
//		
//		return "user/boardDetail";
//	}//boardDetail
//
//	
//	/**
//	 * 寃뚯떆湲� �닔�젙
//	 * @param model �꽦怨듭뿬遺�
//	 * @param ubVO 
//	 * @param session �옉�꽦�옄�� �닔�젙�븯�젮�뒗 �옄 �븘�씠�뵒 ��議�
//	 * @return
//	 */
//	@RequestMapping(value="/user/modifyBoard.do", method=POST)
//	public String modifyBoard(Model model, UserBoardVO ubVO, HttpSession session) {
//		
//		if(ubVO.getUserid() == session.getId()) {
//			model.addAttribute("modifyResult",ubs.modifyBoard(ubVO));
//		}//end if
//		
//		return "user/modifyBoard";
//	}//modifyBoard
//	
//	/**
//	 * 移댄뀒怨좊━ 異쒕젰
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value="/user/category.do", method=GET)
//	public String searchCat(Model model) {
//		
//		model.addAttribute("catList",ubs.category());
//		
//		return "user/category";
//	}//searchCat
//	
//	/**
//	 * �뙎湲� �궘�젣
//	 * @param model �궘�젣 �셿猷�
//	 * @param cm_id �궘�젣�븷 �뙎湲�
//	 * @param session �뙎湲� �벖 �궗�슜�옄�� �쁽�옱 �젒�냽 以� �궗�슜�옄媛� 媛숈쓣 寃쎌슦
//	 * @return
//	 */
//	@RequestMapping(value="/user/deleteComm.do", method=POST)
//	public String removeCom(Model model,@RequestParam(defaultValue = "0") int cm_id, HttpSession session) {
//		
//		UserBoardVO ubVO=new UserBoardVO();
//		
//		if(cm_id != 0 && session.getId() == ubVO.getCm_userid()) {
//			model.addAttribute("deleteComResult",ubs.removeCom(cm_id));	
//		}//end if
//		
//		return "user/deleteComm";
//	}//removeCom
//	
//	@RequestMapping(value="/user/insertComm.do", method=POST)
//	public String addCom(Model model,UserBoardVO ubVO, HttpSession session) {
//		
//			ubVO.setUserid(session.getId());
//			model.addAttribute("deleteComResult",ubs.addCom(ubVO));	
//		
//		return "user/insertComm";
//	}//addCom
//	
//	
//	
//	
//	
//	
//}//class
