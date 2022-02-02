package org.comstudy21.user.model;

import java.util.Vector;

import org.json.JSONObject;

public class UserDto {
	String no;
	String name;
	String email;
	String phone;
	
	public UserDto(int no2, String name, String email, String phone) {
		this.no = ""+no2;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public UserDto() {
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
		if(obj instanceof UserDto) {
			UserDto dto = (UserDto) obj;
			if(name.equals(dto.name)) {
				return true;
			}
		}
		return false;
	}
	
	public JSONObject toJSONObject() {
		JSONObject user = new JSONObject();
		user.put("no", no);
		user.put("name", name);
		user.put("email", email);
		user.put("phone", phone);
		return user;
	}
}
