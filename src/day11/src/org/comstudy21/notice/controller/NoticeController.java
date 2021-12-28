package org.comstudy21.notice.controller;

import org.comstudy21.notice.R;
import org.comstudy21.notice.ViewContainer;
import org.comstudy21.notice.model.NoticeDao;

public class NoticeController {
	private ViewContainer vc = new ViewContainer();
	private NoticeDao dao = new NoticeDao();
	
	public void action() {
		if(R.no == 0) {
			vc.run(R.menuView); // 동적 바인딩 처리 
		}
		switch(R.no) {
			case 1: 
				vc.run(R.insertView);
				dao.insert(R.noticeVo);
				break;
			case 2:
				R.noticeArr = dao.selectAll();
				vc.run(R.noticeListView);
				break;
			case 3:
				vc.run(R.listSelectView);
				 
				if(R.ListNum == 1) {
					vc.run(R.searchByUser);
					R.noticeVo = dao.selectOne(R.noticeVo);
					vc.run(R.listOneView);
				}else {
					vc.run(R.searchWordView);
					R.noticeArr = dao.selectByWord(R.word);
					vc.run(R.listWordView);
				}
				break;
			case 4:
				vc.run(R.searchByUser);
				R.noticeVo = dao.selectOne(R.noticeVo); 
				vc.run(R.noticeEdit);
				if(R.noticeVo != null) {
					dao.update(R.noticeVo);
				}
				break;
			case 5:
				vc.run(R.searchByUser);
				R.noticeVo = dao.selectOne(R.noticeVo);
				if(R.noticeVo != null) {
					vc.run(R.noticeDelete);
					dao.delete(R.noticeVo);
				}
				break;
			case 6:
				System.out.println("프로그램 종료");
				System.exit(0);
			default:
					System.out.println("해당 기능이 없습니다.");
		}
		R.no = 0;
		action();
	}
}
