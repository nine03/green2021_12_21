package day13_2;
// 9번 문제 
import java.util.Scanner;

class Player {
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int select() {
		Scanner scan = new Scanner(System.in);
		System.out.print("철수 [가위(1), 바위(2), 보(3), 끝내기(4)]>>");
		return scan.nextInt();
	}
}

class Computer extends Player {
	
	public Computer(String name) {
		super(name);
	}
	
	public int select() {
		return (int)(Math.random() * 3 + 1);
	}
}

class Game {
	private final String ge[] = {"가위", "바위", "보"};
	Player[] player = new Player[2];
	
	public Game() {
		player[0] = new Player("철수");
		player[1] = new Player("컴퓨터");
	}
	
	public void Run() {
		int userch; // ch : choice
		int computerch; 
		
		while(true) {
			userch = player[0].select();
			
			if(userch < 1 || userch >4) {
				System.out.println("잘못입력 했습니다.");
			}else if(userch == 4) {
				break;
			}
			
			computerch = player[1].select();
			System.out.println(player[0].getName() + "(" + ge[userch - 1] + ") :" + player[1].getName() + "(" + ge[computerch - 1] + ")");
			
			switch(userch - computerch) {
				case 0:
					System.out.println("무승부입니다.");
					break;
				case 2:
				case -1:
					System.out.println(player[1].getName() + "가 이겼습니다.");
					break;
				case -2:
				case 1:
					System.out.println(player[0].getName() + "가 이겼습니다.");
					break;
			}
		}
	}
}

public class test4 {
	public static void main(String[] args) {
		Game ge1 = new Game();
		ge1.Run();
	}
}
