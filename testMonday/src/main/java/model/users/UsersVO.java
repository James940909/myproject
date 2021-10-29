package model.users;

public class UsersVO {
	private int u_num;
	private String id;
	private String pw;
	private String u_name;
	private String u_gender;
	private Double u_height;
	private Double u_weight;
	private int successCnt;
	private String u_profile;
	public int getU_num() {
		return u_num;
	}
	public void setU_num(int u_num) {
		this.u_num = u_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_gender() {
		return u_gender;
	}
	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}
	
	public int getSuccessCnt() {
		return successCnt;
	}
	public void setSuccessCnt(int successCnt) {
		this.successCnt = successCnt;
	}
	public String getU_profile() {
		return u_profile;
	}
	public void setU_profile(String u_profile) {
		this.u_profile = u_profile;
	}
	public Double getU_height() {
		return u_height;
	}
	public void setU_height(Double u_height) {
		this.u_height = u_height;
	}
	public Double getU_weight() {
		return u_weight;
	}
	public void setU_weight(Double u_weight) {
		this.u_weight = u_weight;
	}
	@Override
	public String toString() {
		return "UsersVO [u_num=" + u_num + ", id=" + id + ", pw=" + pw + ", u_name=" + u_name + ", u_gender=" + u_gender
				+ ", u_height=" + u_height + ", u_weight=" + u_weight + ", successCnt=" + successCnt + ", u_profile="
				+ u_profile + "]";
	}
	
	
	
	
	
}
