package ex;

import java.util.Scanner;

public class Game {
	Scanner scan = new Scanner(System.in);
	char[][] map;
	Bear bear;
	Fish fish;
	int inputX = 0, inputY = 0;
	
	Game() {
		run();
	}

	void showMap(Bear bear, Fish fish) {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				map[i][j] = '-';						   // 빈칸을 '-' 로 채운다.
				if(i == fish.getX() && j == fish.getY()) { // fish의 x,y좌표에
					map[i][j] = fish.getShape();		   // fish의 shape('@')를 넣는다.
				}
				if(i == bear.getX() && j == bear.getY()) { // 마찬가지로 bear도.
					map[i][j] = bear.getShape();		   // bear를 나중에 넣는 이유는 
				}										   // bear가 fish를 잡았을때
				System.out.print(map[i][j]);			   // @말고 B가 화면에 남기때문
			}
			System.out.println();
		}
	}
	
	void convertInput(String choice) {
		while(true) {						// 입력받은 이동에 맞춰 x,y값을 1시켜준다.
			if(choice.equals("a")) {
				inputY = -1;
				return;
			} else if(choice.equals("s")) {
				inputX = 1;
				return;
			}else if(choice.equals("w")) {
				inputX = -1;
				return;
			} else if(choice.equals("d")) {
				inputY = 1;
				return;
			} else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}
	
	void userControl(Bear bear, Fish fish) {
		System.out.print("왼쪽(a), 아래(s), 위(w), 오른쪽(d) >> ");
		convertInput(scan.next()); // 입력받은 값을 움직이는값 int로 변환하고
		bear.move(inputX, inputY);
		fish.move(0, 0);
		System.out.print("Bear: (" + bear.getX() + ", " + bear.getY() + ") \t"); // 좌표확인을위해
		System.out.println("Fish: (" + fish.getX() + ", " + fish.getY() + ")");  // 추가함
		
	}
	
	void run() {
		map = new char[10][20];

		bear = new Bear(0, 0, 1);
		fish = new Fish(5, 5, 1);

		System.out.println("** Bear의 Fish 먹기 게임을 시작합니다.**");

		while (true) {
			showMap(bear, fish);
			if(bear.collide(fish)) { // 두 객체가 충돌했을때 메세지 띄우고 종료
				System.out.println("Bear Wins!!");
				break;
			}
			userControl(bear, fish);
		}
	}

	public static void main(String[] args) {
		new Game();
	}
}

