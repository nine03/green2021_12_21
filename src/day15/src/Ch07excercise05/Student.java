package Ch07excercise05;

import java.util.Objects;

class Student {
	String 이름;
	String 학과;
	String 학번;
	String 평균;
	
	public Student () { // 생성자
		this("","","","");
	}
	
	public Student(String 이름, String 학과, String 학번, String 평균) {
		this.이름 = 이름;
		this.학과 = 학과;
		this.학번 = 학번;
		this.평균 = 평균;
	}

	public String get이름() {
		return 이름;
	}

	@Override
	public String toString() {
		return 이름 + "," + 학과 + "," + 학번 + "," + 평균;
	}
	
	public String toString(int i) {
		return "이름:" + 이름 + "\n학과:" + 학과 + "\n학번" + 학번 + "\n학점평균:" + 평균;  
	}

	@Override
	public int hashCode() {
		return Objects.hash(이름);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(이름, other.이름);
	}
	
}