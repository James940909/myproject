package model.post;

import java.sql.Date;

public class PostVO {
	private int pnum;
	private String writer;
	private String title;
	private String content;
	private Date wdate;
	private int member;
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
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
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public int getMember() {
		return member;
	}
	public void setMember(int member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "PostVO [pnum=" + pnum + ", writer=" + writer + ", title=" + title + ", content=" + content + ", wdate="
				+ wdate + ", member=" + member + "]";
	}
	
	

}
