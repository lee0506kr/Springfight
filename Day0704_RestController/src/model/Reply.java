package model;

import java.util.Date;

public class Reply {
	private int replyNum;
	private int boardNum;
	private String replyContent;
	private String replyWriter;
	private Date regDate;
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Reply [replyNum=" + replyNum + ", boardNum=" + boardNum + ", replyContent=" + replyContent
				+ ", replyWriter=" + replyWriter + ", regDate=" + regDate + "]";
	}
	
	
	
	
}
