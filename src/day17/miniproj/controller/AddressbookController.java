package miniproj.controller;

import miniproj.R;
import miniproj.ViewContainer;
import miniproj.model.AddressbookDAO;

public class AddressbookController {
	private static ViewContainer vc = new ViewContainer();
	private static AddressbookDAO dao = new AddressbookDAO();

	public void start() {
			
		vc.run(R.MENU);
		
		switch(R.no) {
		case 1:
			vc.run(R.INPUT);
			if(!(dao.input(R.AddressbookVo)))    
				vc.run(R.ERROR);
			break;
		case 2:
			R.AddressbookList = dao.print();
			vc.run(R.PRINT);
			break;
		case 3:
			vc.run(R.SEARCH);
			R.AddressbookVo = dao.search(R.AddressbookVo);
			vc.run(R.PRINTONE);
			break;
		case 4:
			vc.run(R.SEARCH);
			R.AddressbookVo = dao.search(R.AddressbookVo);
			vc.run(R.UPDATE);
			dao.update(R.AddressbookVo);
			break;
		case 5:
			vc.run(R.SEARCH);
			R.AddressbookVo=dao.search(R.AddressbookVo);
			vc.run(R.DELETE);
			if(R.AddressbookVo != null) {
				dao.delete(R.AddressbookVo);
			}
			break;
		case 6:
			System.out.println("주소록이 종료되었습니다");
			System.exit(0);
		}
		dao.save();
		R.no = 0;
		start();
	}
}
