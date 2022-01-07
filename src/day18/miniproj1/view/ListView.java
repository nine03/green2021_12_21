package miniproj1.view;

import miniproj1.R;
import miniproj1.model.AddressbookDao;
import miniproj1.model.AddressbookVo;

public class ListView extends MenuView {
	@Override
	public void display() {
		System.out.println("-------------------    리스트    -------------------");
		AddressbookDao dao = new AddressbookDao();
		R.AddressbookArr = dao.selectAll();
		print();
		for(AddressbookVo person : R.AddressbookArr) {
			System.out.println(person);
		}
	}

}
