package miniproj.view;

import miniproj.R;

public class MenuView extends AddressbookView {

	@Override
	public void display() {
		System.out.println("--------------------------MENU--------------------------");
		System.out.print("1.입력 2.출력 3.검색 4.수정 5.삭제 6.종료 >> ");
		int no = getNum();
		
		R.no =no;
		
	}
}
