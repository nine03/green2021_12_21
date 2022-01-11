package day20.Ex05;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableEx01 extends JFrame {
	
	Container contentPane;
	JTable table;
	DefaultTableModel tableModel;
	JScrollPane scrollPane;
	
	Object[][] rowData;
	Object[] colNames;
	
	public JTableEx01() { // 생성자
		init(); // 초기화
		start();
	}
	
	private void init() {
		contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		setSize(640,480);
		// 데이터와 테이블 생성 
		mkTbl();
	}
	
	private void mkTbl() {  // 속성 json으로  가져와도된다 . 객체로 들어가도 된다 
		colNames = new Object[]{"idx","name","phone"}; // 표 머리 속성 
		rowData = new Object[][] { // 2차원 배열
			{1,"kim","1111-1111"},
			{2,"lee","2222-2222"},
			{3,"pack","3333-3333"},
			{4,"kang","4444-4444"},
			{5,"hong","5555-5555"},
		};
		
		// 모델 만들어줘야함 
		tableModel = new DefaultTableModel(rowData, colNames); // 테이블 모델 
		table = new JTable(tableModel); // 모델을 테이블로 모델을 만드는 이유는 수정하기 편하기 위해서
		
		scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane);
		
		//// --------------------------- 내용 변경 
		tableModel.setDataVector(null, colNames); // 이렇게하면 데이터를 지우는것 
		tableModel.addRow(new Object[] {3,"ccc","7777"});// 새로운 데이터 추가
		tableModel.addRow(new Object[] {2,"bbb","8888"});
		tableModel.addRow(new Object[] {3,"aaa","9999"});
	}
	
	// 이벤트 처리 
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}


	public static void main(String[] args) {
		new JTableEx01().setVisible(true);
	}
}
