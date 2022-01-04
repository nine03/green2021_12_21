package Ch07excercise05;

import java.util.HashMap;
import java.util.Scanner;

class Location {
	private String name; //도시이름 
	private int Lo; // 경도
	private int La; // 위도 
	
	
	public Location(String name, int Lo,int La) {
		this.name = name;
		this.Lo = Lo;
		this.La = La;
	}

	@Override
	public String toString() {
		return String.format("%s %d %d", name,Lo,La);
	}
	
}
public class test1 {
	public static Scanner scan;
	private HashMap<String, Location> hs = new HashMap<String, Location>();
	public test1() {
		start();
	}
	
	private void start() {
		
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		
	}

	public static void main(String[] args) {
		new test1();
	}
}
