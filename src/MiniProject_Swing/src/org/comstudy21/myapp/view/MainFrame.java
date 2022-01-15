package org.comstudy21.myapp.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import org.comstudy21.myapp.evt.KeyEvtHandler;
import org.comstudy21.myapp.resource.R;

public class MainFrame extends JFrame implements R {
	Container c = null;
	public MainFrame() {
		c = getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(title);
		c.addKeyListener(new KeyEvtHandler());
		// 레이아웃 및 패널 추가
		display();
		// 창 사이즈 조정
		setSize(frameWidth, frameHeight);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}
	// View 패널을 선언한다.
	TitleView titleView = new TitleView();
	InputView inputView = new InputView();
	ListView listView = new ListView();
	BtnView btnView = new BtnView();
	private void display() {
		c.setLayout(new BorderLayout());
		c.add(BorderLayout.NORTH, titleView);
		c.add(BorderLayout.WEST, inputView);
		c.add(BorderLayout.CENTER, listView);
		c.add(BorderLayout.SOUTH, btnView);
	}
}
