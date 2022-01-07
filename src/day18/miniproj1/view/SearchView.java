package miniproj1.view;

import miniproj1.R;
import miniproj1.model.AddressbookVo;

public class SearchView extends View {
	@Override
	public void display() {
		System.out.println("-------------------    검색    -------------------");
			System.out.print("이름 >>");
			String name = sc.next();
			R.AddressbookVo = new AddressbookVo(name,"","");
			System.out.println("검색완료!");
			return;
	}
}
