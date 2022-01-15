package org.comstudy21.myapp.controller;

import javax.swing.JOptionPane;

import org.comstudy21.myapp.model.Dao;
import org.comstudy21.myapp.model.Dto;

public class DeleteController implements Controller {

	public void service() {
		if(txtName.getText() == "") {
			JOptionPane.showMessageDialog(null, "삭제 할 이름을 입력 하세요!");
			return;
		}
		
		Dao.delete(new Dto(null, txtName.getText(),null, null));
		// 결과를 파일에 저장 하기
		Dao.saveDataList();
		JOptionPane.showMessageDialog(null, "삭제 완료!");
		// 리스트 갱신하기
		
		txtNo.setText("");
		txtName.setText("");
		txtEmail.setText("");
		txtPhone.setText("");
		
		ctrlMap.get(btnAll).service();
	}

}
