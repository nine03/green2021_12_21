package org.comestudy21.miniproj;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.out;

class Student {
	public int no; // 번호
	public String name; // 이름 
	public int kor, eng, mat;
	public int sum; // 국영수의 총점
	public double avg; // 국영수 총점의 평균
	public String grade; // 학점
	public int rank; // 등수
	
	public Student() {
		// 디폴트생성자 - 인자가 없다. 아무일도 하지 않는다.
	}

	public Student(int no, String name, int kor, int eng, int mat) {
		
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
		//총점, 평균, 학점을 만들어 준다.
	this.sum = kor + eng + mat;
	this.avg = sum / 3;
	
	if(avg <= 100 && avg >= 90) {
		this.grade = "A";
		}else if(avg < 90 && avg >= 80) {
			this.grade = "B";
		}else if(avg < 80 && avg >= 70) {
			this.grade = "C";
		}else if(avg < 70 && avg >= 60) {
			this.grade ="D";
		}else if(avg < 60 && avg >= 50) {
			this.grade = "F";
		}
	}

	// 객체를 사용하면 toString()이 자동 호출된다.
	@Override
	public String toString() {
		return no + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t"
				+ sum + "\t" + avg + "\t" + grade + "\t" + rank;
	}
}
//Student st1 = new Student();
//st1.name = "홍길동"
//Studnet st2 = new Student(1,"김길동",60,70,80);

public class MainCls {
	public static final Scanner scan = new Scanner(System.in);
	
	public static void Basic() { 
		System.out.printf("[번호]\t[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]\t[학점]\t[등수]\n"); 
		}
	public static final int MAX = 100;
	// 저장된 배열을 만들려면 무슨타입인가 ? 
	static Student[] sArr = new Student[MAX];
	static int top = 0; // sArr에 0번지  스텍 자료구조처럼.
	static int sequence = 1;
	
	
	// static 초기화 블록
	static {
		sArr[top++] = new Student(sequence++,"KIM",60,60,75);
		sArr[top++] = new Student(sequence++,"LEE",90,80,80);
		sArr[top++] = new Student(sequence++,"PARK",90,100,95);
	}
	
	
	public static int menu() {
		
		int no = 0;
		
		while(true) {
		out.println("1.입력 2.출력 3.검색 4.수정 5.삭제 6.종료");
		out.print("선택 >>");
		no = scan.nextInt();
		// 예외처리 및 유효성 검사
		if(no > 6 || no < 0) {
			out.println("범위 초과! 1~6 사이의 번호를 입력해주세요.");
		}else if(no <= 6) {
			break;
			}
		}
		return no;
	}
	public static void run() {
		switch(menu()) {
		case 1 : input(); break;
		case 2 : output(); break;
		case 3 : search(); break;
		case 4 : modify(); break;
		case 5 : delete(); break;
		case 6 : end(); break;
		default : out.print("--- 해당 사항 없습니다! ---");
		}
		out.println("------------------------------------");
	   }
	
	private static void end() {
		out.print("::::: END :::::\n");
		out.println("프로그램 종료!");
		out.println("수고하셨습니다!");
		System.exit(0);
		
	}
	
	private static void delete() {
		out.print("::::: DELETE :::::\n");
		// 이름으로 검색 후 삭제
		int count = 0;
		out.print("검색할 이름을 입력해주세요.");
		String name = scan.next();
		int i = 0;
		for(i = 0; i < top; i++) {
			if(name.equals(sArr[i].name)) {
			Basic();
			out.println(sArr[i]);
			count++;
			break;
		}
	  }
		if(count == 0) {
			out.println("그 이름의 데이터는 존재하지 않습니다.");
		}else {
			out.println("데이터를 삭제하시려면 1를 입력하세요. 그렇지 않다면 2를 입력해주세요.");
			int check = scan.nextInt();
			if(check == 1) {
				sArr[i] = new Student();
				out.println("데이터를 삭제하였습니다.");
			}else if(check == 2) {
				out.println("데이터 삭제를 취소합니다.");
			}
		}
	}
	
	private static void modify() {
		out.print("::::: MODIFY :::::\n");
		// 이름으로 검색 후 수정 
		int count = 0;
		System.out.print("검색할 이름을 입력하여주십시오 >> ");
		String name = scan.next();
		int i = 0;
			for(i=0; i<top; i++) {
				if(name.equals(sArr[i].name)) {
					Basic();
					System.out.println(sArr[i]);
					count++;
					break;
				} 
			}
			if(count == 0) {
				System.out.println("그 이름의 데이터는 존재하지 않습니다.");
			} else {
				System.out.println("수정할 데이터를 입력해주십시오.");
				int kor =0, eng=0, mat = 0;
				kor = score("국어");
				eng = score("영어");
				mat = score("수학");
				sArr[i] = new Student(sArr[i].no,name, kor,eng,mat);
				}
	}
	
	private static void search() {
		out.print("::::: SEARCH :::::\n");
		// 이름으로 검색
		int count = 0;
		out.print("검색할 이름을 입력하세요.");
		String name = scan.next();
		
		for(int i = 0; i < top; i++) {
			if(name.equals(sArr[i].name)) {
				Basic();
				out.println(sArr[i]);
				count++;
			}
		}
		if(count == 0 ) {
			out.println("그 이름은 존재하지 않습니다.");
		}
	}
	
	private static void output() {
		out.print("::::: OUTPUT :::::\n");
		//  배열의 목록 출력
		//  번호,성명,국어,영어,수학,총점,평균,학점,등수,등수를 기준으로 정렬
		
		for(int i = 0; i < sArr.length; i++) {
			if(sArr[i] == null) break;
			sArr[i].rank = 0;
		}
		
		for(int i = 1; i< sArr.length; i++) {
			if(sArr[i] == null) break;
				for(int j = i; j >= 1; j--) {
					if(sArr[j].sum > sArr[j-1].sum) {
						Student temp = sArr[j];
						sArr[j] = sArr[j-1];
						sArr[j-1] = temp;
					}else break;
				}
		}
		
		
		for(int i = 0; i < sArr.length; i++) {
			if(sArr[i] == null) break;
			sArr[i].rank = i + 1;
		}
		
		Basic();
		for(Student std : sArr) {
			if(std == null) break;
			if(std.name != null) {
				out.println(std);
			}
		}
	}
	
	public static int score(String a) {
		int num = 0;
		while(true) {
			out.printf("%s ",a);
			num = scan.nextInt();
			if(num < 0 || num > 100) {
				out.println("범위 초과 1~ 100 사이의 숫자를 입력해주세요.");
			}else if(num <= 100) {
				break;
			}
		}
		return num;
	}
	
	private static void input() {
		out.print("::::: INPUT :::::\n");
		// 성명, 국어, 영어, 수학를 배열에 입력 받는다.
		// 입력 받은 국영수 점수의 총점과 평균, 평균의 학점, 
		// 입력된 학생의 등수가 셋팅 된다.
		
		String name =" ";
		while(true) {
			out.println("이름>> ");
			name = scan.next();
			if(name.length() > 4) {
				out.println("글자수 초과 4글자로 이하로 입력해주세요.");
			}else if(name.length()<= 4) {
				break;
			}
		}
		
		int kor = 0;
		int eng = 0;
		int mat = 0;
		kor = score("국어");
		eng = score("영어");
		mat = score("수학");
		
		sArr[top++] = new Student(sequence++, name,kor,eng,mat);
	}
	public static void main(String[] args) {
		out.println("::::: 성적 출력 프로그램 :::::");
		while(true) {
			run();
		}
	}
}
