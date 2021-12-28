package org.comstudy21.notice.view;

import org.comstudy21.notice.R;

public class ListOneView extends NoticeView {
	 @Override
	public void display() {
		if(R.noticeVo == null) {
			System.out.println("메시지를 찾을 수 없습니다.");
			return;
		}
		System.out.println(R.noticeVo);
	}
}
