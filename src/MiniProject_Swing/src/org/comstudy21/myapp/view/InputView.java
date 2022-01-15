package org.comstudy21.myapp.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InputView extends View {
	JPanel leftPane = new JPanel(new GridLayout(5,1));
	JPanel titPane = new JPanel();
	
	public InputView() {
		display();
	}

	@Override
	public void display() {
		add(leftPane);
		titPane.add(new JLabel(":::: INPUT ::::"));
		leftPane.add(titPane);
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("   NO   : "));
		p1.add(txtNo);
		leftPane.add(p1);
		
		JPanel p2 = new JPanel();
		p2.add(new JLabel("NAME : "));
		p2.add(txtName);
		leftPane.add(p2);
		
		JPanel p3 = new JPanel();
		p3.add(new JLabel("EMAIL : "));
		p3.add(txtEmail);
		leftPane.add(p3);
		
		JPanel p4 = new JPanel();
		p4.add(new JLabel("PHONE : "));
		p4.add(txtPhone);
		leftPane.add(p4);
	}

}
