package org.comstudy21.notice.view;

import org.comstudy21.notice.R;

public class ListSelectView extends NoticeView {
	@Override
	public void display() {
		int no = 0;
		
		
		while(true) {
			try {
				System.out.println("검색할 항목을 선택하세요");
				System.out.println("1.유저 2. 단어");
				System.out.println("선택>> ");
				no = scan.nextInt();
				
				while(no < 1 || no > 2) {
					System.out.println("범위를 벗어났습니다");
					System.out.println("다시 선택 >>");
					no = scan.nextInt();
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요");
				scan.next();
				continue;
			}
			
		}
		R.ListNum = no;
	}
}
