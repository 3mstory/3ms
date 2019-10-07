package co.worker.threeminutessul.likeyhate.model;

import lombok.Data;

@Data
public class ResultLHVO extends LikeHateVO {
	private int likecount;
	private int hatecount;
	private String isLikeHate;
}
