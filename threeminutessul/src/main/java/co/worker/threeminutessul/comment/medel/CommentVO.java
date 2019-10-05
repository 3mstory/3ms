package co.worker.threeminutessul.comment.medel;

import co.worker.threeminutessul.common.model.CommonVO;
import lombok.Data;

@Data
public class CommentVO extends CommonVO{
	
	private int commentSeq;
	private int parSeq; //이부분 어떻게 할것인가.
	private String content;
	private String regdate;
	private String updatedate;
	private int isanony;
	private int mentionUserSeq;
	private String nickname;
	
	private int commentCnt;
	private int likecnt;
	private int hatecnt;
	private String boardContent;
	
	//등록성공여부
	private int result;

}
