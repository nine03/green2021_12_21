package homework;

public class PersonInfo {

	private int PN; // 고유 번호
	private String name;  // 이름	
	private int age; // 나이
	private String sex; // 성별
	private String number; // 집전화
	private String phonenumber; // 휴대폰번호
	
	public int getPN() {
		return PN;
	}
	
	public void setPN(int pn) {
		this.PN = pn;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getNumber() {
		return number;
	}
	   public void setNumber(String number) {
	        this.number = number;
	    }
	 
	    public String getPhonenumber() {
	        return phonenumber;
	    }
	 
	    public void setPhonenumber(String phonenumber) {
	        this.phonenumber = phonenumber;
	    }
	    
	    public void showInfo() {
	        System.out.println("이름 : " + this.name);
	        System.out.println("나이 : " + this.age);
	        System.out.println("성별 : " + this.sex);
	        System.out.println("전화번호 : " + this.number);
	        System.out.println("휴대폰번호 : " + this.phonenumber);
	    }
}
