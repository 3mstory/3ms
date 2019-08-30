package co.worker.threeminutessul.common.model;

public class CommonVO {
	private int boardSeq;
	private int userSeq;
	private String userid;
	
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "commonVO [boardSeq=" + boardSeq + ", userSeq=" + userSeq + ", userid=" + userid + "]";
	}
}
