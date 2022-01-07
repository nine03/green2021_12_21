package miniproj1.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class AddressbookVo implements Externalizable {
	private String name;
	private String phoneNum;
	private String email;
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
	      out.writeUTF(name);
	      out.writeUTF(phoneNum);
	      out.writeUTF(email);
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
	      name = in.readUTF();
	      phoneNum = in.readUTF();
	      email = in.readUTF();	
	}
	
	public AddressbookVo() {
		this("", "", "");
	}
	
	public AddressbookVo(String name, String phoneNum, String email) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return name + "\t" + phoneNum + "\t" + email;
	}


}
