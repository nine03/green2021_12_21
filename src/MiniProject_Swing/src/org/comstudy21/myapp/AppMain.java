package org.comstudy21.myapp;

import org.comstudy21.myapp.model.Dao;
import org.comstudy21.myapp.view.MainFrame;

public class AppMain {

	public static void main(String[] args) {
		Dao.loadDataList();
		
		new MainFrame();
	}
}
