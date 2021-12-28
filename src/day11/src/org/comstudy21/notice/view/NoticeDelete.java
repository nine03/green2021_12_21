package org.comstudy21.notice.view;

import org.comstudy21.notice.R;

public class NoticeDelete extends NoticeView {
	@Override
	public void display() {
		System.out.println("::::: 사람 정보 삭제 :::::");
		if(R.noticeVo == null) {
			System.out.println("검색 결과가 없습니다!");
			return;
		}
		System.out.println(R.noticeVo);
		System.out.println("정말로 삭제 하시겠습니까?(y/n)");
		char yn = scan.next().charAt(0);
		if(yn == 'n' ) {
			R.noticeVo = null;
		}
	}
}
