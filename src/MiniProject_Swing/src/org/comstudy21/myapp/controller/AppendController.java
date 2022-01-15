package org.comstudy21.myapp.controller;

import org.comstudy21.myapp.model.Dao;
import org.comstudy21.myapp.model.Dto;

public class AppendController implements Controller {

	public void service() {
		//System.out.println("AppendController ...");
		// 텍스트 필드에 입력된 값을 받아온다.
		// Dto 객체를 만든다.
		Dto dto = new Dto();
		dto.setNo(txtNo.getText());
		dto.setName(txtName.getText());
		dto.setEmail(txtEmail.getText());
		dto.setPhone(txtPhone.getText());
		txtNo.setText("");
		txtName.setText("");
		txtEmail.setText("");
		txtPhone.setText("");
		
		// Dao에 dto 객체를 추가한다.
		Dao.insert(dto);
		
		// 목록 갱신하기
		ctrlMap.get(btnAll).service();
	}

}
