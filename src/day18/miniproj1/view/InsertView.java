package miniproj1.view;

import miniproj1.R;
import miniproj1.model.AddressbookVo;

public class InsertView extends View{
	@Override
	public void display() {
		System.out.println("-------------------    입력    -------------------");
		System.out.print("이름 >>");
		String name = sc.next();
		System.out.print("전화번호 >>");
		String phoneNum = sc.next();
		System.out.print("이메일 >>");
		String email = sc.next();
		R.AddressbookVo = new AddressbookVo(name, phoneNum, email);
	}
}
