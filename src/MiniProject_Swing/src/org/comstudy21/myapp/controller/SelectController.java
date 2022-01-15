package org.comstudy21.myapp.controller;

import java.util.ArrayList;

import org.comstudy21.myapp.model.Dao;
import org.comstudy21.myapp.model.Dto;

public class SelectController implements Controller {

	public void service() {
		// loadDataList() 테스트
		//Dao.loadDataList();
		
		ArrayList<Dto> list = Dao.selectAll();
		
		// 기존의 데이터를 비워주고 시작한다.
		dataVector.clear();
		for(Dto dto : list) {
			dataVector.add(dto.getVector());
		}

		// 데이터 테이블 모델 갱신
		dm.setDataVector(dataVector, columnIdentifiers);
	}

}
