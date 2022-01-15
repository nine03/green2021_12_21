package org.comstudy21.myapp.evt;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import org.comstudy21.myapp.resource.R;
import org.comstudy21.myapp.view.ListView;

public class MouseEvtHandler extends MouseAdapter implements R {
	ListView target;
	
	public MouseEvtHandler(ListView target) {
		this.target = target;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// 마우스를 눌렀을때 반응하는 메소드
		JTable table = target.table;
		
		int row = table.getSelectedRow();
		int column = table.getSelectedColumn();
		
		//System.out.println(dm.getValueAt(row, column));
		
		//System.out.print(dm.getValueAt(row, 0)+", ");
		//System.out.print(dm.getValueAt(row, 1)+", ");
		//System.out.print(dm.getValueAt(row, 2)+", ");
		//System.out.println(dm.getValueAt(row, 3));
		
		// 텍스트 필드에 표시하기
		txtNo.setText((String)dm.getValueAt(row, 0));
		txtName.setText((String)dm.getValueAt(row, 1));
		txtEmail.setText((String)dm.getValueAt(row, 2));
		txtPhone.setText((String)dm.getValueAt(row, 3));
	}
}
