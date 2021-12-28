package org.comstudy21.saram.view;

import org.comstudy21.saram.R;

public class SaramEdit extends SaramView {
	@Override
	public void display() {
		System.out.println("::::: 사람 정보 수정 :::::");
		if(R.saramVo == null) {
			System.out.println("검색 결과 없습니다!");
			return;
		}
		System.out.println(R.saramVo);
		System.out.print("이름을 수정 하시겠습니까?(Y/N)");
		char yn = scan.next().charAt(0);
		if(yn == 'Y' || yn == 'y') {
			System.out.print("새 이름>> ");
			R.saramVo.setName(scan.next());
		}
		System.out.print("연락처을 수정 하시겠습니까?(Y/N)");
		yn = scan.next().charAt(0);
		if(yn == 'Y' || yn == 'y') {
			System.out.print("새 연락처>> ");
			R.saramVo.setPhone(scan.next());
		}
		System.out.print("이메일을 수정 하시겠습니까?(Y/N)");
		yn = scan.next().charAt(0);
		if(yn == 'Y' || yn == 'y') {
			System.out.print("새 이메일>> ");
			R.saramVo.setEmail(scan.next());
		}
	}
}
