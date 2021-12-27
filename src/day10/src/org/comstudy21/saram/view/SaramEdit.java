package org.comstudy21.saram.view;

import org.comstudy21.saram.R;
import org.comstudy21.saram.model.SaramVo;

public class SaramEdit extends SaramView {
	@Override
	public void display() {
		System.out.println("::::: 사람 정보 수정 :::::");
		//System.out.print("검색할 이름>> ");
		int ps = 0;
		if(R.saramVo == null) {
			System.out.println("해당된 사람이 없습니다.");
		} else {
			System.out.println("수정하시겠습니까?");
			System.out.println("1.이름 2. 전화번호 3. 이메일");
			System.out.print("선택 >> ");
			ps = scan.nextInt();
			
			switch(ps) {
			case 1:
				System.out.println("이름을 재입력 해주세요.");
				System.out.print("이름 : ");
				String Name1 = scan.next();
				R.saramVo.setName(Name1);
				break;
			case 2:
				System.out.println("전화번호를 재입력 해주세요.");
				System.out.println("전화번호 : ");
				String Phone1 = scan.next();
				R.saramVo.setPhone(Phone1);
				break;
			case 3:
				System.out.println("이메일을 재입력 해주세요.");
				System.out.println("이메일 : ");
				String Email1 = scan.next();
				R.saramVo.setEmail(Email1);
				break;
			}
			System.out.println("수정이 완료되었습니다.");
		}
		
		
	}
}
