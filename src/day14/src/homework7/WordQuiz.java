package homework7;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;
//  open challenge
class Word {
	private String english;
	private String korean;
	public Word(String english, String korean) {
		this.english = english;
		this.korean = korean;
	}
	public String getEnglish() { 
		return english; 
		}
	public String getKorean() { 
		return korean; 
		}
	
}
public class WordQuiz {
	private String name;
	private Vector<Word> v;

	public WordQuiz(String name) {
		this.name = name;
		v = new Vector<Word>();
		v.add(new Word("love", "사랑"));
		v.add(new Word("animal", "동물"));
		v.add(new Word("emotion", "감정"));
		v.add(new Word("human", "인간"));
		v.add(new Word("stock", "주식"));
		v.add(new Word("trade", "거래"));
		v.add(new Word("society", "사회"));
		v.add(new Word("baby", "아기"));
		v.add(new Word("honey", "꿀"));
		v.add(new Word("dall", "인형"));
		v.add(new Word("bear", "곰"));
		v.add(new Word("picture", "사진"));
		v.add(new Word("painting", "그림"));
		v.add(new Word("fault", "오류"));
		v.add(new Word("example", "보기"));
		v.add(new Word("eye", "눈"));
		v.add(new Word("statue", "조각상"));
	}

	private int makeExample(int ex[], int answerIndex) {
		int n[] = {-1, -1, -1, -1};
		int index;
		for(int i=0; i<n.length; i++) {
			do {
				index = (int)(Math.random()*v.size());
			} while(index == answerIndex || exists(n, index));
			n[i] = index;
		}

		for(int i=0; i<n.length; i++) ex[i] = n[i];
		return (int)(Math.random()*n.length);
	}
	
	private boolean exists(int n[], int index) {
		for(int i=0; i<n.length; i++) {
			if(n[i] == index)
				return true;
		}
		return false;
	}
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\"" + name + "\"" + "의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
		System.out.println("현재 " + v.size() + "개의 단어가 들어 있습니다.");
		while(true) { 
			int answerIndex = (int)(Math.random()*v.size()); 
			String eng = v.get(answerIndex).getEnglish();
			
			
			int example[] = new int [4];
			
			int answerLoc = makeExample(example, answerIndex);
			example[answerLoc] = answerIndex; 

			
			System.out.println(eng + "?");
			for(int i=0; i<example.length; i++)
				System.out.print("(" + (i+1) + ")" + v.get(example[i]).getKorean() + " "); 
			
			System.out.print(":>"); 
			try {
				int in = scanner.nextInt(); 
				if(in == -1) {
					break; 
				}

				
				in--; 
				if(in == answerLoc)
					System.out.println("Excellent !!");
				else
					System.out.println("No. !!");
			}
			catch(InputMismatchException e) {
				scanner.next();
				System.out.println("숫자를 입력하세요 !!");
				
			}
		}
		System.out.print("\"" + name + "\"를 종료합니다...");		
		scanner.close();		
	}
	
	public static void main(String[] args) {
		WordQuiz quiz = new WordQuiz("명품영어");
		quiz.run();
	}
}
