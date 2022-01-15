package org.comstudy21.myapp.view;

import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.comstudy21.myapp.evt.MouseEvtHandler;
import org.comstudy21.myapp.model.Dto;

public class ListView extends View {
	public ListView() {
		columnIdentifiers.add("NO");
		columnIdentifiers.add("NAME");
		columnIdentifiers.add("EMAIL");
		columnIdentifiers.add("PHONE");
		dm.setColumnCount(4);

		display();
		
		MouseEvtHandler l = new MouseEvtHandler(this);
		table.addMouseListener(l);
	}
	
	@Override
	public void display() {
		//add(new JLabel("List view"));
		add(new JScrollPane(table));
		setBackground(Color.WHITE);
	}

}
