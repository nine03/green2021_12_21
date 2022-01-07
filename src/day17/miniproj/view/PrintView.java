package miniproj.view;

import java.util.Iterator;

import miniproj.R;
import miniproj.model.AddressbookVo;

public class PrintView extends AddressbookView {
	@Override
	public void display() {
		System.out.println("--------------------------PRINT-------------------------");
		if (R.AddressbookList == null) {
			System.out.println("저장된 목록이 없습니다!");
			return;
		}
		System.out.println("저장된 목록을 출력합니다!");

		Iterator<AddressbookVo> it = R.AddressbookList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
