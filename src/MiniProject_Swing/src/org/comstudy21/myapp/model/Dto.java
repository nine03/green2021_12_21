package org.comstudy21.myapp.model;

import java.util.Vector;

public class Dto {
	String no;
	String name;
	String email;
	String phone;
	
	public Dto(String no, String name, String email, String phone) {
		this.no = no;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public Dto() {
		no = "";
		name = "";
		email = "";
		phone = "";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Dto [no=" + no + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	public Vector<String> getVector() {
		Vector<String> v = new Vector<>();
		v.add(no);
		v.add(name);
		v.add(email);
		v.add(phone);
		return v;
	}
	
	// hashCode와 equals를 재정의 해야 한다.
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Dto) {
			Dto dto = (Dto) obj;
			if(name.equals(dto.name)) {
				return true;
			}
		}
		return false;
	}
}
