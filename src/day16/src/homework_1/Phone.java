package homework_1;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Phone implements Externalizable{
	private String name;
	private String tel;
	private String email; 
	
	public void writeExternal(ObjectOutput objop) throws IOException {
		objop.writeUTF(name);
		objop.writeUTF(tel);
		objop.writeUTF(email);
	}
	
	public void readExternal(ObjectInput objin) throws IOException { 
		name = objin.readUTF();
		tel = objin.readUTF();
		email = objin.readUTF();
	}
		
	public Phone() {
		this("","",""); 
	}
	
	public Phone(String name, String tel, String email) { 
		this.name = name;
		this.tel = tel;
		this.email = email;
	}
	
	public int hashCode() { 
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public String toString() {
		return name + "  " + tel + "  " + email;
	}

}
