package org.comstudy21.myapp.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.comstudy21.myapp.controller.AppendController;
import org.comstudy21.myapp.controller.DeleteController;
import org.comstudy21.myapp.controller.ResetController;
import org.comstudy21.myapp.controller.SearchController;
import org.comstudy21.myapp.controller.SelectController;
import org.comstudy21.myapp.evt.BtnEvtHandler;

public class BtnView extends View {
	public BtnView() {
		display();
	}
	
	@Override
	public void display() {
		//add(new JLabel("Button view"));
		add(btnAll);
		add(btnAppend);
		add(btnSearch);
		add(btnDelete);
		add(btnReset);
		
		// 이벤트 핸들러가 다른 클래스 파일에 있다.
		// 이벤트 핸들러에서 버튼에 접근 하려면  this를 전달 해야 한다.
		BtnEvtHandler l = new BtnEvtHandler(this);
		btnAll.addActionListener(l);
		btnAppend.addActionListener(l);
		btnDelete.addActionListener(l);
		btnSearch.addActionListener(l);
		btnReset.addActionListener(l);
		
		setBackground(BG_COLOR);
	}

}
