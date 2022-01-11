package homework1;


public class Members {
	int memberID;
	String phone;
	String name;
	String sex;
	String openDate;
	String balance;
	
	public Members() {
		super();
	}
	public Members(int memberID, String phone, String name, String sex, String openDate, String balance) {
		super();
		this.memberID = memberID;
		this.phone = phone;
		this.name = name;
		this.sex = sex;
		this.openDate = openDate;
		this.balance = balance;
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
}
