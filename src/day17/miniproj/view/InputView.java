package miniproj.view;

import miniproj.R;
import miniproj.model.AddressbookVo;

public class InputView extends AddressbookView {
	@Override
	public void display() {
		System.out.println("--------------------------INPUT-------------------------");
		System.out.println("이름, 전화번호, 이메일을 입력해 주세요!");
		System.out.print("이름 >> ");
		String name = getLine();
		System.out.print("전화번호 >> ");
		String tel = getLine();
		System.out.print("이메일 >> ");
		String email = getLine();
		
		R.AddressbookVo = new AddressbookVo(0,name,tel,email);
	}
}
