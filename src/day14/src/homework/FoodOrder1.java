package homework;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class  FoodOrder1 {
	static Queue q = new LinkedList();
	static int exprice = 0;
	static boolean bool = true;

	static void save(String input) {
		if (!"".equals(input))
			q.offer(input);
	}
	static void exprice(int price) {
		exprice += price;
	}
	
	static void start() {
		System.out.println("카페를 입력해주세요.");
		while (true) {
			System.out.print(">>");
			try {
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim();
				if ("".equals(input))
					continue;
				if (input.equalsIgnoreCase("종료")) {
					System.out.println("종료합니다....");
					System.exit(0);
				} else if (input.equalsIgnoreCase("카페")) {
					restaurant();
				} else if (input.equalsIgnoreCase("메뉴")) {
					menu();
				} else if (input.equalsIgnoreCase("영수증")) {
					receipt();
				} else {
					System.out.println("다시 입력 하세요");
					continue;
				}} catch (Exception e) {
					System.out.println("입력오류 입니다.");
				}
		}
	}
	
	static void restaurant() {
		System.out.println(" ");
		System.out.println("------------------ 카페에 들어오셨습니다.  -------------------------------------");
		System.out.println("------------------ 메뉴를 선택해주세요. (메뉴를 눌러주세요)  -----------------------");
		System.out.println("----------주문하신 메뉴 총 금액을 출력합니다. (영수증을 눌러주세요) ---------------------");
		System.out.println("------------------ 프로그램을 종료합니다. (종료를 눌러주세요) -----------------------");
		System.out.println("-------------------------------------------------------------------------");
	} 
	static void menu() {
		System.out.println(" ");
		System.out.println("------------------ 메뉴를 선택해주세요. ---------------------------------------");
		System.out.println("--------(아메리카노) (카페모카) (카페라떼) (에스프레소) (사과주스) (종료)----------------");
		System.out.println("-------------------------------------------------------------------------");
		Scanner s2 = new Scanner(System.in);
		String menu;
		System.out.print("메뉴 입력>>");
		while (true) {
			menu = s2.nextLine().trim();
			if (menu.equals("아메리카노")) {
				System.out.println("아메리카노를 입력하셨습니다.");
				exprice(5000);
				save(menu);
			} else if (menu.equals("카페모카")) {
				System.out.println("카페모카를 입력하셨습니다.");
				exprice(4500);
				save(menu);
			} else if (menu.equals("카페라떼")) {
				System.out.println("카페라떼를 입력하셨습니다.");
				exprice(5500);
				save(menu);
			} else if (menu.equals("에스프레소")) {
				System.out.println("에스프레소를 입력하셨습니다.");
				exprice(4000);
				save(menu);
				
			} else if (menu.equals("사과주스")) {
				System.out.println("사과주스를 입력하셨습니다.");
				exprice(3500);
				save(menu);
			} else if (menu.equals("종료")) {
				System.out.println("종료를 입력하셨습니다.");
				restaurant();
				break;
			}
		}
	}
	
	static void receipt() {
		System.out.println("");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("(영수증) - 주문하신 메뉴와 총 금액입니다.");
		System.out.println("-------------------------------------------------------------------------");
		int i = 0;
		
		
		LinkedList tmp = (LinkedList) q;
		ListIterator it = tmp.listIterator();
		while (it.hasNext()) {
			System.out.println(++i + "." + it.next());
		}
		System.out.println("");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("청구금액 :                                                 " + exprice + "원");
		System.out.println("-------------------------------------------------------------------------");
	}
	public static void main(String[] args) {
		
		start();
	}
}
