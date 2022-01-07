package miniproj1.view;

import miniproj1.R;

public class MenuView extends View {
	
	@Override
	public void display() {
		System.out.println("-------------------    메뉴    -------------------");
		while(true) {
			try {
				System.out.println("1.입력 2.출력 3.검색 4.수정 5.삭제 6.저장 7.불러오기 8.종료");
				System.out.print("선택 >>");
				choice = sc.nextInt();
			} catch (Exception e) {
				sc.next();
				System.out.println("정수만 입력하시오.");
				continue;
			}
			break;
		}
		
		R.choice = choice;
	}

}
