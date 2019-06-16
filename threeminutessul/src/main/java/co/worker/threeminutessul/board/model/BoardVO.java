package co.worker.threeminutessul.board.model;

public class BoardVO {
	private int boardSeq;
	private String writer;
	private String title;
	private String content;
	private String regdate;
	private String updatedate;
	private int likey;
	private int hate;
	private String isanony;
	
	
	//추가요소..
	private String profile;
	private String userid;
	private String preText;
	
	public String getPreText() {
		return preText;
	}
	public void setPreText(String preText) {
		this.preText = preText;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
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
	public String getIsanony() {
		return isanony;
	}
	public void setIsanony(String isanony) {
		this.isanony = isanony;
	}
	@Override
	public String toString() {
		return "BoardVO [boardSeq=" + boardSeq + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + ", likey=" + likey + ", hate=" + hate
				+ ", isanony=" + isanony + ", profile=" + profile + ", userid=" + userid + ", preText=" + preText + "]";
	}
	
}
