package miniproj1.view;

import miniproj1.R;

public class DetailView extends View {
	@Override
	public void display() {
		System.out.println("-------------------    정보    -------------------");
		if(R.AddressbookVo == null) {
			System.out.println("정보가 없습니다.");
		} else {
			print();
			System.out.println(R.AddressbookVo);			
		}
	}

}
