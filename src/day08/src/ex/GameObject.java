package ex;

import java.util.Random;
import java.util.Scanner;


public abstract class GameObject {
	protected int distance; // 한번이동거리
	protected int x, y; // 현재위치
	
	public GameObject(int startX, int startY, int distance)	 {//초기 위치와 이동 거리 설정
		this.x = startX;
		this.y = startY;
		this.distance = distance;
	}
	
	public int getX() { 
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) { // 좌표에 움직임 추가를 위해 x,y setter 생성
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean collide(GameObject p) { // 충돌했을때 true 리턴
		if(this.x == p.getX() && this.y == p.getY()) {
			return true;
		} else {
			return false;
		}
	}
	
	protected abstract void move(int inputX, int inputY); // 이동 후의 새로운 위치로 x, y 변경
	protected abstract char getShape(); // 객체의 모양을 나타내는 문자 리턴
}

class Bear extends GameObject {
	
	public Bear(int startX, int startY, int distance) {
		super(startX, startY, distance);
	}

	protected void move(int inputX, int inputY) {
		if(!(getX() == 0 && inputX == -1)) { //bear가 맵 밖으로 나가려고할때 제외
			this.x += inputX; 
		}
		if(!(getY() == 0 && inputY == -1)) {
			this.y += inputY;
		}
	}
	
	protected char getShape() {
		return 'B';
	}
	
}

class Fish extends GameObject {
	Random rand = new Random();
	int randomMove;
	int cnt = 1;
	
	public Fish(int startX, int startY, int distance) {
		super(startX, startY, distance);
	}
	
	protected void move(int x, int y) {
		if(cnt < 4) { // fish는 3번 이동금지
			cnt++;
			return;
		} else { // 2번 랜덤 한칸 이동
			randomMove = rand.nextInt(4);
			switch(randomMove) {
			case 0 :
				setX(getX() + 1);
				break;
			case 1 :
				setX(getX() - 1);
				break;
			case 2 :
				setY(getY() + 1);
				break;
			case 3 :
				setY(getY() - 1);
			}
			if(cnt == 5) { // 2번 이동하면 cnt를 다시 처음값 1로 초기화.
				cnt = 1;
				return;
			}
			cnt++;
		}
	}
	
	protected char getShape() {
		return '@';
	}
	
}
