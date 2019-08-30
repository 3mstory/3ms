package co.worker.threeminutessul.likeyhate.model;

import co.worker.threeminutessul.common.model.CommonVO;

public class LikeHateVO extends CommonVO{
	private int likehateSeq; //테이블 PK
	//private int boardSeq; 	//글번호
	//private int userSeq;	//사용자번호
	private int isLike; 	//좋아요누름?
	private int isHate;		//싫어요누름?
	
	public int getLikehateSeq() {
		return likehateSeq;
	}
	public void setLikehateSeq(int likehateSeq) {
		this.likehateSeq = likehateSeq;
	}
	
	public int getIsLike() {
		return isLike;
	}
	public void setIsLike(int isLike) {
		this.isLike = isLike;
	}
	public int getIsHate() {
		return isHate;
	}
	public void setIsHate(int isHate) {
		this.isHate = isHate;
	}
	
}
