package miniproj1.view;

import miniproj1.R;

public class SaveView extends View {
	@Override
	public void display() {
		
		System.out.println("-------------------    저장    -------------------");
		System.out.print("저장 파일명 >> ");
		R.fileName = sc.next();
	}
}
