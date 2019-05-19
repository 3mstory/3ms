package co.worker.threeminutessul.board.model;

import java.util.Calendar;

public class BoardVO {
	private int boardSeq;
	private String writer;
	private String title;
	private String content;
	private Calendar regdate;
	private Calendar updatedate;
	private int likey;
	private int hate;
	private int isanony;
	
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Calendar getRegdate() {
		return regdate;
	}
	public void setRegdate(Calendar regdate) {
		this.regdate = regdate;
	}
	public Calendar getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Calendar updatedate) {
		this.updatedate = updatedate;
	}
	public int getLikey() {
		return likey;
	}
	public void setLikey(int likey) {
		this.likey = likey;
	}
	public int getHate() {
		return hate;
	}
	public void setHate(int hate) {
		this.hate = hate;
	}
	public int getIsanony() {
		return isanony;
	}
	public void setIsanony(int isanony) {
		this.isanony = isanony;
	}
}
