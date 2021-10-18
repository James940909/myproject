package model.testBoard;

import java.sql.Date;

public class testBoardVO {
	
	private int bnum;
	private String title;
	private String content;
	private String writer;
	private Date pdate;
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	@Override
	public String toString() {
		return "testBoardVO [bnum=" + bnum + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", pdate=" + pdate + "]";
	}
	
	
	
}
