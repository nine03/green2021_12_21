package org.comstudy21.myapp.controller;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.comstudy21.myapp.model.Dao;
import org.comstudy21.myapp.model.Dto;

public class SearchController implements Controller {

	public void service() {
		//System.out.println("SearchController ...");
		String searchName = txtName.getText();
		
		Dto member = Dao.findMember(new Dto(null, searchName, null, null));
		if(member == null) {
			System.out.println("멤버가 없습니다!");
		}else {
			// 목록에 있던 내용을 지운다.
			while(dm.getRowCount() > 0) {
				System.out.println("removed");
				dm.removeRow(0);
			}
			
			//System.out.println(member);
			dataVector.clear();
			dataVector.add(member.getVector());
			
			//System.out.println(dataVector.size());
			//System.out.println(dm.getRowCount());
			// 데이터 테이블 모델 갱신
			//dm.setDataVector(dataVector, columnIdentifiers);
			dm.fireTableCellUpdated(0, 10);
		}
	}

}
