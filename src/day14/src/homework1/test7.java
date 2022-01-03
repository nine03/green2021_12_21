package homework1;

import java.util.*;
// 7번 문제
class test7 {
	private String title;
	private Scanner scanner = new Scanner(System.in);
	private HashMap<String, Double> scoreMap = new HashMap<String, Double>();
	
	public test7(String name) {
		this.title = name;
	}
	public void read() {
		System.out.println(title + "관리시스템입니다.");
		for(int i=0; i<5; i++) {
			System.out.print("이름과 학점>> ");
			String name = scanner.next();
			double score = scanner.nextDouble();
			scoreMap.put(name,  score);
		}		
	}
	
	public void select() {
		System.out.print("장학생 선발 학점 기준 입력>> ");
		double cutline = scanner.nextDouble();
		
		System.out.print("장학생 명단 : ");
		Set<String> nameSet = scoreMap.keySet();
		Iterator<String> it = nameSet.iterator();
		while(it.hasNext()) {
			String name = it.next();
			double score = scoreMap.get(name);
			if(score > cutline)
				System.out.print(name + " ");
		}
		System.out.println();
	}
	
	public static void main(String [] args) {
		test7 sship = new test7("미래장학금");
		sship.read();
		sship.select();
	}
}