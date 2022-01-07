package miniproj1.view;

import miniproj1.R;
import miniproj1.model.AddressbookVo;

public class DeleteView extends View {
	@Override
	public void display() {
		System.out.println("-------------------    삭제    -------------------");
		System.out.print("삭제하고 싶은 사람의 이름 입력 >>");
		String name = sc.next();
		R.AddressbookVo = new AddressbookVo(name,"","");
	}
}
