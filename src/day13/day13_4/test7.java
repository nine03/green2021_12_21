package day13_4;
// 12번 문제
import java.util.Scanner;

class Person {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String turn() {
		Scanner scan = new Scanner(System.in);
		System.out.print("[" + name + "]:");
		return scan.nextLine();
	}
	
	public boolean RandomNum() {
		int num[] = new int[3];
		
		for(int i = 0; i < 3; i++) {
			num[i] = (int)(Math.random() * 3 + 1);
			System.out.print(num[i] + "\t");
		}
		
		boolean result = true;
		for(int i = 0; i < 3; i++) {
			if(num[0] != num[i]) {
				result = false;
				break;
			}
		}
		return result;
	}
}

class Game {
	Person person[];
	Scanner scan = new Scanner(System.in);
	
	public Game() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("갬블링 게임에 참여할 선수 숫자>>");
		int num = scan.nextInt();
		
		person = new Person[num];
		
		for(int i = 0; i < person.length; i++) {
			System.out.print((i + 1) + "번째 선수 이름>>");
			person[i] = new Person(scan.next());
		}
	}
	
	public void Run() {
		while(true) {
			for(int i = 0; i < person.length; i++) {
				String s = person[i].turn();
				if(s.equals("")) {
					System.out.println("<Enter>");
				}else {
					System.out.println("<Enter>키만 입력 가능합니다.");
					return ;
				}
				
				if(person[i].RandomNum()) {
					System.out.println(person[i].getName() + "님이 이겼습니다!");
					return;
				} else {
					System.out.println("아쉽군요!");
				}
			}
		}
	}
}

public class test7 {
	public static void main(String[] args) {
		Game game = new Game();
		game.Run();
	}
}
