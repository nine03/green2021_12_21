package homework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
// OpenChallenge
public class OpenChallenge {
	
	ArrayList<String> words = new ArrayList<String>();
	Scanner scanWords = new Scanner(new FileReader("words.txt"));
	Scanner scan = new Scanner(System.in);
	char[] question;
	final int WORDS_SIZE = 30;
	
	int randomNum;
	char answer = ' ';
	int cnt = 0;
	int answerCnt = 0;
	boolean flag = false;
	
	public OpenChallenge() throws FileNotFoundException {
		while(scanWords.hasNext()) {			
			String word = scanWords.nextLine();
			words.add(word);
		}
		System.out.println("지금부터 행맨 게임을 시작합니다.");
		while(true) {
			init();
			run();
		}
	}
	
	public void init() {						
		randomNum = 0;
		cnt = 0;
		answerCnt = 0;
		answer = ' ';
	}
	
	public void run() {
		Random rand = new Random();
		Random rand2_1 = new Random();
		Random rand2_2 = new Random();
		randomNum = rand.nextInt(WORDS_SIZE);
		
		question =  words.get(randomNum).toCharArray();	
		
		int questionSize = question.length;				
		int randomNum2_1;
		int randomNum2_2;
		
		while(true) {
			randomNum2_1 = rand2_1.nextInt(questionSize);	
			randomNum2_2 = rand2_2.nextInt(questionSize);	
			if(randomNum2_1 == randomNum2_2) {				
				continue;
			}
			break;
		}
		
		for(int i=0; i<question.length; i++) {		
			if(i == randomNum2_1) {					
				System.out.print("-");
			} else if( i == randomNum2_2) {			
				System.out.print("-");
			} else {
				System.out.print(question[i]);
			}
		}
		System.out.println();
		
		while(true) {
			System.out.print(">> ");
			String tmpAnswer = scan.next();			
			answer = tmpAnswer.charAt(0);			
			
			if(answer == question[randomNum2_1]) {	
				answerCnt++;						
				flag = true;						
			}
			if(answer == question[randomNum2_2]) {	
				answerCnt++;						
				flag = false;						
			}
			
			if(answerCnt == 1) {						
				if(flag) {									
					for(int i=0; i<question.length; i++) {	
						if( i == randomNum2_2) {
							System.out.print("-");
						} else {
							System.out.print(question[i]);
						}
					}
					System.out.println();
				} else if (!flag) {						 
					for(int i=0; i<question.length; i++) {	
						if( i == randomNum2_1) {
							System.out.print("-");
						} else {
							System.out.print(question[i]);
						}
					}
					System.out.println();
				}
			}
			
			if(answerCnt == 2) {						
				choice();								
				return;									
			}
			
			cnt++;										
			
			if(cnt == 5) {								
				System.out.println("5번 실패하였습니다.");
				choice();								
				return;
			}
		}
		
	}
	
	public void choice() {
		for(int i=0; i<question.length; i++) {			
			System.out.print(question[i]);
		}
		System.out.println();
		System.out.print("Next(y/n)? ");				
		String choice = scan.next();
		if(choice.equals("y")) {						
			return;
		} else {
			System.out.println("종료");					
			System.exit(0);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		new OpenChallenge();

	}

}
