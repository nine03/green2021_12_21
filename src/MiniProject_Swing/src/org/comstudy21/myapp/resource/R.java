package org.comstudy21.myapp.resource;

import java.awt.Color;
import java.awt.Container;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.comstudy21.myapp.controller.Controller;
import org.comstudy21.myapp.model.Dto;

public interface R {
	// 상수값을 한곳에 모아 둔다.
	// 결합도는 낮추고, 응집력은 높이는 프로그래밍
	// 결합도가 높은 프로그램은 스파게티코드이다.
	String title = "::: Memeber Management System :::";
	int frameWidth=720, frameHeight=480;
	
	// JTextField는 View와 Controller에서 모두 접근해야 한다.
	JTextField txtNo = new JTextField(10);
	JTextField txtName = new JTextField(10);
	JTextField txtEmail = new JTextField(10);
	JTextField txtPhone = new JTextField(10);
	
	Color BG_COLOR = new Color(0x0000ff);
	
	Vector dataVector = new Vector();
	Vector columnIdentifiers = new Vector();
	DefaultTableModel dm = new DefaultTableModel(dataVector, columnIdentifiers);
	JTable table= new JTable(dm);
	
	JButton btnAll = new JButton("전체보기");
	JButton btnAppend = new JButton("추가");
	JButton btnDelete = new JButton("삭제");
	JButton btnSearch = new JButton("검색");
	JButton btnReset = new JButton("데이터 불러오기");
	
	HashMap<JButton, Controller> ctrlMap = new HashMap<>();
	
}
