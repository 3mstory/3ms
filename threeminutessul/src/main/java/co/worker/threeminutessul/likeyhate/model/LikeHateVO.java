package co.worker.threeminutessul.likeyhate.model;

import co.worker.threeminutessul.common.model.CommonVO;
import lombok.Data;

@Data
public class LikeHateVO extends CommonVO{
	private int likehateSeq; //테이블 PK
	//private int boardSeq; 	//글번호
	//private int userSeq;	//사용자번호
	private int isLike; 	//좋아요누름?
	private int isHate;		//싫어요누름?
	
	private int result;
	private int isMyClicked;
	private String type;
}
