package org.comstudy21.notice.view;

import org.comstudy21.notice.R;

public class SearchWordView extends NoticeView {
	@Override
	public void display() {
		System.out.println("단어를 입력해 주세요.");
		System.out.println("입력>> ");
		String s = scan.next();
		
		R.word = s;
	}
}
