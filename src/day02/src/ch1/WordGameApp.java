package ch1;

import java.util.Scanner;

public class WordGameApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int playerNum;
        String lastWord = "아버지"; // 시작 제시어 초기화
        Scanner in = new Scanner(System.in);
        
        System.out.println("끝말잇기 게임을 시작합니다...");
        System.out.print("게임에 참가하는 인원은 몇명입니까>>");
        playerNum = in.nextInt();
        
        Player[] players = new Player[playerNum]; // 입력받은 숫자를 객체 배열의 갯수로 설정
        
        for(int i = 0;i < playerNum; i++) { // 빈 객체의 배열을 각각 이름으로 초기화
            System.out.print("참가자의 이름을 입력하세요>>");
            String name = in.next();
            players[i] = new Player(name);
        }
        
        System.out.println("시작하는 단어는 아버지입니다.");
        while(true) {
            for(int i=0;i<playerNum;i++) {
                String name = players[i].name; 
                System.out.print(name + ">>");
                players[i].sayWord(in.next()); // in.next를 players[i]번째 객체의 word 변수에 저장
                if(players[i].succeed(lastWord) == true) {
                    lastWord = players[i].word;
                }
                else {
                    System.out.println(name + "이 졌습니다.");
                    System.exit(0);
                }
            }
        }
	}

}
