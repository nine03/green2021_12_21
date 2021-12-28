package org.comstudy21.notice.model;

public class NoticeVo {
	private int no;
	private String user;
	private String message;
	private String regDate;
	
	public NoticeVo() {
		this(0,"","","");
	}
	// 생성자
	public NoticeVo(int no, String user, String message, String regDate) {
		this.no = no;
		this.user = user;
		this.message = message;
		this.regDate = regDate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return  no + "\t" + user + "\t" + message + "\t" + regDate;
	}
	
	
}
