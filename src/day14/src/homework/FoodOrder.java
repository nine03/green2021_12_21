package homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class FoodOrder {

	private int tableNum;
	private int totalPrice;
	private HashMap<String, Integer> menu;
	private Queue<String> orderList ;


	public FoodOrder(int tableNum){
		this.tableNum = tableNum;
		this.totalPrice = 0;
		this.menu = new HashMap<String, Integer> ();
		this.orderList = new LinkedList<String>();
		getMenu();

	}

	public Queue<String> getOrderList() {
		return orderList;
	}

	public void setOrderList(Queue<String> orderList) {
		this.orderList = orderList;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}

	public void order(String food) {
		if (checkOrder(food)) {
			orderList.offer(food);
			totalPrice += menu.get(food);
			}
		
	}
	
	public boolean checkOrder(String food){
		if (menu.containsKey(food)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void showMenu() {
		System.out.println("------------------------------------------");
		System.out.println("\t\t 메뉴 \t\t");
		System.out.println("------------------------------------------");
		System.out.println("1. 아메리카노  2. 카푸치노  3. 핫초코  4. 에이드");
		System.out.println("------------------------------------------");
	}

	public void getBill() {
		System.out.println("------------------------------------------");
		System.out.println("\t\t 영수증 \t\t");
		System.out.println("------------------------------------------");
		
		Iterator<String> iter = orderList.iterator();
		while(iter.hasNext()) {
				String food = iter.next();
				int price = menu.get(food);
				System.out.printf("- %s : %d원\n ", food, price);
		}
		System.out.println("주문 합계 : "+this.totalPrice + "원입니다.");
	}
	
	public void getMenu(){
		String[] name = {"아메리카노", "카푸치노", "핫초코", "에이드"};
		int[] price = {2900, 5900, 3900, 4900};
		
		for(int i =0; i<name.length;i++) {
			menu.put(name[i], price[i]);
		}
	}
	public static void main(String[] args) {
		new FoodOrder(1).showMenu();
	}
}