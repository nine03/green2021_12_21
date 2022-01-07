package miniproj1.controller;

import java.io.IOException;

import miniproj1.R;
import miniproj1.ViewContainer;
import miniproj1.model.AddressbookDao;

public class AddressbookController {
	private ViewContainer vc = new ViewContainer();
	private AddressbookDao dao = new AddressbookDao();
	
	public void action() throws IOException, ClassNotFoundException {
		if(R.choice == 0) {
			vc.run(R.menu);
		}
		
		switch(R.choice) {
		case 1:
			vc.run(R.insert);
			dao.insert(R.AddressbookVo);
			break;
		case 2:
			vc.run(R.list);
			break;
		case 3:
			vc.run(R.search);
			R.AddressbookVo = dao.selectByName(R.AddressbookVo);
			vc.run(R.detail);
			break;
		case 4:
			vc.run(R.search);
			R.AddressbookVo = dao.selectByName(R.AddressbookVo);
			vc.run(R.edit);
			dao.update(R.AddressbookVo);
			break;
		case 5:
			vc.run(R.delete);
			dao.delete(R.AddressbookVo);
			break;
		case 6:
			vc.run(R.save);
			dao.save(R.fileName);
			break;
		case 7:
			vc.run(R.load);
			dao.load(R.fileName);
			break;
		case 8:
			System.out.println("종료 되었습니다.");
			return;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
		R.choice = 0;
		action();
	}
	
}
