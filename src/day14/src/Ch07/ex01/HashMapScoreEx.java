package Ch07.ex01;
import java.util.*;

public class HashMapScoreEx {
	public static void main(String[] args) {
		// 사용자 이름과 점수를 기록하는 HashMap 컬렉션 생성
		HashMap<String, Integer> javaScore = new HashMap<String, Integer>();
		
		// 5 개의 점수 저장
		javaScore.put("김성동", 97);
		javaScore.put("황기태", 88);
		javaScore.put("김남윤", 98);
		javaScore.put("이재문", 70);
		javaScore.put("한원선", 99);

		System.out.println("HashMap의 요소 개수 :" + javaScore.size());
		
		// 모든 사람의 점수 출력. 
		// javaScore에 들어 있는 모든 (key, value) 쌍 출력
		 // key 문자열을 가진 집합 Set 컬렉션 리턴
		Set<String> keys = javaScore.keySet(); // 순서가 없다 

		// key 문자열을 순서대로 접근할 수 있는 Iterator 리턴
		Iterator<String> it = keys.iterator(); 
		while(it.hasNext()) {
			String name = it.next();
			int score = javaScore.get(name);
			System.out.println(name + " : " + score);
		}
	}
}
