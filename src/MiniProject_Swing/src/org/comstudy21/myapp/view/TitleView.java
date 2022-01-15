package org.comstudy21.myapp.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TitleView extends View {
	
	public TitleView() {
		display();
	}

	@Override
	public void display() {
		// 상속을 받았기 때문에 TitleView가 곧 JPanel이다.
		// JPanel의 모든 기능 사용가능.
		// JFrame에 View 객체를 붙일 수 있다. 
		JLabel lblTitle = new JLabel(title);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 28));
		this.add(lblTitle);
		
		setBackground(BG_COLOR);
		lblTitle.setForeground(Color.WHITE);
	}
}
