package org.comstudy21.notice.view;

import org.comstudy21.notice.R;
import org.comstudy21.notice.model.NoticeVo;

public class ListWordView extends NoticeView {
	@Override
	public void display() {
		if(R.noticeArr == null) {
			System.out.printf("\"%s\"를 포함한 메세지를 찾을 수 없습니다!\n",R.word);
			return;
		}
		System.out.printf("\"%s\" 를 포함한 메세지 목록입니다. \n",R.word);
		for(NoticeVo vo : R.noticeArr) {
			if(vo == null) {
				return;
			}
			System.out.println(vo);
		}
	}
}
