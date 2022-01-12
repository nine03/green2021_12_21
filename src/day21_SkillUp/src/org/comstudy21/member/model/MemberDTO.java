package org.comstudy21.member.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;

public class MemberDTO implements Externalizable {
	private int idx;
	private String name;
	private String email;
	private String phone;
	
	public MemberDTO() {
		this(0,"","","");
	}

	public MemberDTO(int idx, String name, String email, String phone) {
		this.idx = idx;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
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
		// return  idx + "\t" + name + "\t" + email + "\t" + phone;
		return String.format("%4d%10s%20s%20s", idx,name,email,phone); // 문자열 포멧으로 만들기 4d는 내칸을 잡고 - 4d %10 10칸을 잡아라
	}

	@Override
	public int hashCode() {
		return Objects.hash(idx);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDTO other = (MemberDTO) obj;
		return idx == other.idx;
	}
	
	@Override
	protected Object clone() {
		try {
			return new MemberDTO(idx,name,email,phone);
		} catch (Exception e) {}
		return null;
		// 클론을 만들지않으면 매번 DAO에서 반복해야한다
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(idx); // 쓰는쪽
		out.writeObject(name); 
		out.writeObject(email); 
		out.writeObject(phone); 
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		idx = (Integer)in.readObject();	// 읽어오는쪽  int는 형변환
		name = (String)in.readObject();
		email = (String)in.readObject();
		phone = (String)in.readObject();
	}
}
