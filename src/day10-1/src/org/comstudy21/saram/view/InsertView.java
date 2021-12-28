package org.comstudy21.saram.view;

import org.comstudy21.saram.R;
import org.comstudy21.saram.model.SaramVo;

public class InsertView extends SaramView {
	@Override
	public void display() {
		System.out.println("::::: 입력 기능 :::::");
		// 성명, 전화, 이메일
		// R.saramVo에 저장 후 Controller로 이동
		System.out.print("성명 입력>> ");
		String name = scan.next();
		System.out.print("전화 입력>> ");
		String phone = scan.next();
		System.out.print("이메일>> ");
		String email = scan.next();
		
		R.saramVo = new SaramVo(0, name, phone, email);
		System.out.println("입력 완료!");
		// 작업 완료후 자동으로 Controller로 이동.
	}
}
