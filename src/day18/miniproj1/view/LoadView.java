package miniproj1.view;

import miniproj1.R;

public class LoadView extends View {
	@Override
	public void display() {
		System.out.println("-------------------    불러오기    -------------------");
		System.out.print("불러오기 파일명 >> ");
		R.fileName = sc.next();
	}
}
