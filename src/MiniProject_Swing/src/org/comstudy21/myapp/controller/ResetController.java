package org.comstudy21.myapp.controller;

import org.comstudy21.myapp.model.Dao;

public class ResetController implements Controller {

	public void service() {
		///System.out.println("ResetController ...");
		
		// 파일에 저장 된 내용르로 갱신한다.
		// json 파일의 데이터 로드하기.
		Dao.loadDataList();
		
		ctrlMap.get(btnAll).service();
	}
}
