package miniproj.view;

import miniproj.R;
import miniproj.model.AddressbookVo;

public class SearchView extends AddressbookView {
	@Override
	public void display() {
		System.out.println("-------------------------SEARCH-------------------------");
		System.out.println("이름을 입력해주세요");
		System.out.print("이름 >> ");
		String name = getLine();
		
		R.AddressbookVo = new AddressbookVo(0,name, null, null);
	}
}
