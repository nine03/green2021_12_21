package org.comstudy21.notice.view;

import org.comstudy21.notice.R;
import org.comstudy21.notice.model.NoticeVo;

public class SearchByUser extends NoticeView {
	@Override
	public void display() {
		System.out.println("::::: 사람 정보 검색 :::::");
		System.out.print("검색 할 이름>> ");
		String user = scan.next();
		R.noticeVo = new NoticeVo(0,user,null,null);
	}
}
