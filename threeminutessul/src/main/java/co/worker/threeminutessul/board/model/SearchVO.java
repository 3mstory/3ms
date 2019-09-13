package co.worker.threeminutessul.board.model;

import lombok.Data;

@Data
public class SearchVO {
	private String searchoption;
	private String searchtext;
	private Integer page;
	
	//category 정보
	private Integer category;
}
