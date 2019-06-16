package co.worker.threeminutessul.user.model;

public class UserVO {
	
	private String userSeq;
	private String userid;
	private String userpw;
	private String nickname;
	private String profile;
	
	public String getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(String userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "UserVO [userSeq=" + userSeq + ", userid=" + userid + ", userpw=" + userpw + ", nickname=" + nickname
				+ ", profile=" + profile + "]";
	}
	
}
