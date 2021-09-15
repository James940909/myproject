package model.msg;

public class ReplyVO {
	private int rid;
	private int mid;
	private String userid;
	private String rmsg;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRmsg() {
		return rmsg;
	}
	public void setRmsg(String rmsg) {
		this.rmsg = rmsg;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [rid=" + rid + ", mid=" + mid + ", userid=" + userid + ", rmsg=" + rmsg + "]";
	}
	
	
	
}
