package co.worker.threeminutessul.likeyhate.model;

public class HateVO {
	private int userSeq;
	private int boardSeq;
	private int isdupl;
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public int getIsdupl() {
		return isdupl;
	}
	public void setIsdupl(int isdupl) {
		this.isdupl = isdupl;
	}
	@Override
	public String toString() {
		return "HateVO [userSeq=" + userSeq + ", boardSeq=" + boardSeq + ", isdupl=" + isdupl + "]";
	}
}
