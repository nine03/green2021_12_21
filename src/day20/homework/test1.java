package homework;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class test1 extends JFrame {
	Container contentpane;
	JScrollPane centerpane;
	JPanel westpane;
	JPanel southpane;
	JPanel left1;
	JPanel left2;
	
	JTextField txt1;
	JTextField txt2;
	JTextField txt3;
	JTextField txt4;
	
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	
	JTable table;
	DefaultTableModel tableModel;
	Object[][] rowData;
	Object[] colNames;
	
	public test1() {
		init();
		start();
	}
	
	public void init() {
		setTitle("");
		setSize(640,300);
		
		contentpane = getContentPane();
		GridLayout grid = new GridLayout(8,1);
		grid.setVgap(10);
		westpane = new JPanel(new BorderLayout());
		left1 = new JPanel(grid);
		left2 = new JPanel(grid);
		
		southpane = new JPanel();
		txt1 = new JTextField(10);
		txt2 = new JTextField(10);
		txt3 = new JTextField(10);
		txt4 = new JTextField(10);
		
		btn1 = new JButton("전체보기");
		btn2 = new JButton("추 가");
		btn3 = new JButton("삭 제");
		btn4 = new JButton("검 색");
		btn5 = new JButton("취 소");
		
		tableInit();
	}
	
	private void tableInit() {
		colNames = new Object[] {"번호","이름","전화번호","이메일"};
		rowData = new Object[][] {
			{1, "kim", "010-1111-1111", "kim@gmail.com"},
			{2, "lee", "010-2222-2222", "lee@gmail.com"},
			{3, "park", "010-3333-3333", "park@gmail.com"},
			
		};
		
		tableModel = new DefaultTableModel(rowData, colNames);
		table = new JTable(tableModel);
		centerpane = new JScrollPane(table);
		contentpane.add(centerpane);
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		contentpane.add(westpane, BorderLayout.WEST);
		contentpane.add(southpane, BorderLayout.SOUTH);
		
		left1.add(btn1);
		
		left1.add(new JLabel("번       호"));
		left1.add(new JLabel("이       름"));
		left1.add(new JLabel("전화번호"));
		left1.add(new JLabel("이  메  일"));
		
		left2.add(txt1);
		left2.add(txt2);
		left2.add(txt3);
		left2.add(txt4);
		
		westpane.add(left1,BorderLayout.WEST);
		westpane.add(left2,BorderLayout.CENTER);
		
		southpane.add(btn1);
		southpane.add(btn2);
		southpane.add(btn3);
		southpane.add(btn4);
		southpane.add(btn5);
	}

	
	public static void main(String[] args) {
		new test1().setVisible(true);
	}

}