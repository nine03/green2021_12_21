package ch1;

import java.util.Scanner;

public class WordGameApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int playerNum;
        String lastWord = "�ƹ���"; // ���� ���þ� �ʱ�ȭ
        Scanner in = new Scanner(System.in);
        
        System.out.println("�����ձ� ������ �����մϴ�...");
        System.out.print("���ӿ� �����ϴ� �ο��� ����Դϱ�>>");
        playerNum = in.nextInt();
        
        Player[] players = new Player[playerNum]; // �Է¹��� ���ڸ� ��ü �迭�� ������ ����
        
        for(int i = 0;i < playerNum; i++) { // �� ��ü�� �迭�� ���� �̸����� �ʱ�ȭ
            System.out.print("�������� �̸��� �Է��ϼ���>>");
            String name = in.next();
            players[i] = new Player(name);
        }
        
        System.out.println("�����ϴ� �ܾ�� �ƹ����Դϴ�.");
        while(true) {
            for(int i=0;i<playerNum;i++) {
                String name = players[i].name; 
                System.out.print(name + ">>");
                players[i].sayWord(in.next()); // in.next�� players[i]��° ��ü�� word ������ ����
                if(players[i].succeed(lastWord) == true) {
                    lastWord = players[i].word;
                }
                else {
                    System.out.println(name + "�� �����ϴ�.");
                    System.exit(0);
                }
            }
        }
	}

}
