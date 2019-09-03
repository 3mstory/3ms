package co.worker.threeminutessul.board.model;

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
	
	
	public String getTimechange() {
		return timechange;
	}
	public void setTimechange(String timechange) {
		this.timechange = timechange;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
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
	public int getWriter() {
		return writer;
	}
	public void setWriter(int writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
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
	public int getIsanony() {
		return isanony;
	}
	public void setIsanony(int isanony) {
		this.isanony = isanony;
	}
	@Override
	public String toString() {
		return "BoardVO [boardSeq=" + boardSeq + ", writer=" + writer + ", title=" + title + ", contents=" + contents
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + ", likey=" + likey + ", hate=" + hate
				+ ", isanony=" + isanony + ", profile=" + profile + ", userid=" + userid + ", nickname=" + nickname
				+ ", preText=" + preText + "]";
	}
	
}
