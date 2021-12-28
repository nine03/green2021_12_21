package org.comstudy21.notice.view;

import org.comstudy21.notice.R;

public class NoticeEdit extends NoticeView {
	@Override
	public void display() {
		System.out.println("::::: 유저 정보 수정 :::::");
		if(R.noticeVo == null) {
			System.out.println("검색 결과 없습니다!");
			return;
		}
		System.out.println(R.noticeVo);
		System.out.print("유저 이름을 수정 하시겠습니까?(Y/N)");
		char yn = scan.next().charAt(0);
		if(yn == 'Y' || yn == 'y') {
			System.out.println("새 유저 이름>>");
			R.noticeVo.setUser(scan.next()); 
		}
		System.out.println("메시지를 수정 하시겠습니가?(Y/N)");
			yn = scan.next().charAt(0);
			if(yn == 'Y' || yn == 'y') {
			System.out.println("새 메세지 입력>>");
			R.noticeVo.setMessage(scan.next());
		}
	}
}
