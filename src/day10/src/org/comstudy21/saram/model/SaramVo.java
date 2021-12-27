package org.comstudy21.saram.model;

public class SaramVo {
	private int no;
	private String name;
	private String phone;
	private String email;
	
	public SaramVo() {
		this(0, "", "", "");
	}
	public SaramVo(int no, String name, String phone, String email) {
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return no + "\t" + name + "\t" + phone + "\t" + email;
	}
}