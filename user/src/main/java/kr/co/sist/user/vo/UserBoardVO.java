package kr.co.sist.user.vo;

public class UserBoardVO {
	private String title, userid, input_date, cat_name, cm_input_date,imgfile,cm_userid;
	private int bd_id, cat_num, recommend, views, cm_id,rownum, totalCnt,pageScale,currentPage,pageCnt,startNum,endNum ;
	private String description, cm_description;
	private char isdeleted;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getInput_date() {
		return input_date;
	}
	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public String getCm_input_date() {
		return cm_input_date;
	}
	public void setCm_input_date(String cm_input_date) {
		this.cm_input_date = cm_input_date;
	}
	public String getImgfile() {
		return imgfile;
	}
	public void setImgfile(String imgfile) {
		this.imgfile = imgfile;
	}
	public String getCm_userid() {
		return cm_userid;
	}
	public void setCm_userid(String cm_userid) {
		this.cm_userid = cm_userid;
	}
	public int getBd_id() {
		return bd_id;
	}
	public void setBd_id(int bd_id) {
		this.bd_id = bd_id;
	}
	public int getCat_num() {
		return cat_num;
	}
	public void setCat_num(int cat_num) {
		this.cat_num = cat_num;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getCm_id() {
		return cm_id;
	}
	public void setCm_id(int cm_id) {
		this.cm_id = cm_id;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public int getPageScale() {
		return pageScale;
	}
	public void setPageScale(int pageScale) {
		this.pageScale = pageScale;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCm_description() {
		return cm_description;
	}
	public void setCm_description(String cm_description) {
		this.cm_description = cm_description;
	}
	public char getIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(char isdeleted) {
		this.isdeleted = isdeleted;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	
}