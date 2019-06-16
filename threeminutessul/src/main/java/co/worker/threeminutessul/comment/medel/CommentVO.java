package co.worker.threeminutessul.comment.medel;

public class CommentVO {
	
	private int commentSeq;
	private int userSeq;
	private int boardSeq;
	private int parSeq;
	private String content;
	private String regdate;
	private String updatedate;
	private int isanony;
	
	public int getCommentSeq() {
		return commentSeq;
	}
	public void setCommentSeq(int commentSeq) {
		this.commentSeq = commentSeq;
	}
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
	public int getParSeq() {
		return parSeq;
	}
	public void setParSeq(int parSeq) {
		this.parSeq = parSeq;
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
	public int getIsanony() {
		return isanony;
	}
	public void setIsanony(int isanony) {
		this.isanony = isanony;
	}
	@Override
	public String toString() {
		return "CommentVO [commentSeq=" + commentSeq + ", userSeq=" + userSeq + ", boardSeq=" + boardSeq + ", parSeq="
				+ parSeq + ", content=" + content + ", regdate=" + regdate + ", updatedate=" + updatedate + ", isanony="
				+ isanony + "]";
	}
}
