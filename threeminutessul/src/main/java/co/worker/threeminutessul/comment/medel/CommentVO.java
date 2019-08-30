package co.worker.threeminutessul.comment.medel;

import co.worker.threeminutessul.common.model.CommonVO;

public class CommentVO extends CommonVO{
	
	private int commentSeq;
	private int parSeq; //이부분 어떻게 할것인가.
	private String content;
	private String regdate;
	private String updatedate;
	private int isanony;
	private int mentionUserSeq;
	private String nickname;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getMentionUserSeq() {
		return mentionUserSeq;
	}
	public void setMentionUserSeq(int mentionUserSeq) {
		this.mentionUserSeq = mentionUserSeq;
	}
	public int getCommentSeq() {
		return commentSeq;
	}
	public void setCommentSeq(int commentSeq) {
		this.commentSeq = commentSeq;
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
		return "CommentVO [commentSeq=" + commentSeq + ", parSeq=" + parSeq + ", content=" + content + ", regdate="
				+ regdate + ", updatedate=" + updatedate + ", isanony=" + isanony + ", mentionUserSeq=" + mentionUserSeq
				+ ", nickname=" + nickname + "]";
	}

}
