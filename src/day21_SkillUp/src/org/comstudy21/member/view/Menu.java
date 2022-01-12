package org.comstudy21.member.view;

public class Menu extends MemberView {

	@Override
	public boolean onCreate() {
		System.out.println(titleMenu);
		System.out.println("1.입력 2.출력 3.검색 4.수정 5.삭제 6.종료");
		System.out.println("선택:");
		no = scan.nextInt();
		while(no<1 || no>6) { // 유효성체크
			System.out.println("범위를 벗어난 입력입니다.");
			System.out.println("다시 선택:");
			no = scan.nextInt();
		}
		return true;
	}

}
