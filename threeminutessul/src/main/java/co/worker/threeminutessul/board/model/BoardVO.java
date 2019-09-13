package co.worker.threeminutessul.board.model;

import lombok.Data;

@Data
public class BoardVO {
	private int boardSeq;
	private int writer; //=userSeq
	private String title;
	private String contents;
	private String regdate;
	private String updatedate;
	private int likey;
	private int hate;
	private int isanony;	
	
	//추가요소..
	private String profile;
	private String userid; //=id
	private String nickname;//=닉네임
	private String timechange;
	private Integer category;
		
}
