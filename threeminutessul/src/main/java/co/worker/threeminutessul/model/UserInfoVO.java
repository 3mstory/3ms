package co.worker.threeminutessul.model;

public class UserInfoVO {

	private String userid;
	private String userpw;
	private String nickname;
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
	@Override
	public String toString() {
		return "UserInfoVO [userid=" + userid + ", userpw=" + userpw + ", nickname=" + nickname + "]";
	}
}
