package homework;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import day20.Ex03.Ex03JOptionPan;

public class test2 extends JFrame {

	Container conPan= getContentPane();
	JTable table;
	DefaultTableModel dTable;
	JScrollPane scrollPane;
	
	Object[][] rowData;
	Object[] colNames;
	
	JPanel leftPan, leftInPan1, leftInPan2, leftInPan3, leftInPan4, botPan;
	JLabel numLabel, nameLabel, emailLabel, phoneLabel;
	JTextField numTf, nameTf, emailTf, phoneTf;
	JButton Btn1, Btn2, Btn3, Btn4, Btn5;
	
	public test2() {
		this("",640,300);
		
	}
	
	protected void init() {
		Btn1 = new JButton("전체보기");
		Btn2 = new JButton("추 가");
		Btn3 = new JButton("삭 제");
		Btn4 = new JButton("검 색");
		Btn5 = new JButton("취 소");
	}
	
	private void display() {
		init();
		conPan = getContentPane();
		botPan = new JPanel(new FlowLayout());
		leftPan = new JPanel(new GridLayout(5,1));
		leftInPan1 = new JPanel();
		leftInPan2 = new JPanel();
		leftInPan3 = new JPanel();
		leftInPan4 = new JPanel();
		
		numLabel = new JLabel("번호        ");
		nameLabel = new JLabel("이름       ");
		emailLabel = new JLabel("이메일    ");
		phoneLabel = new JLabel("전화번호");
		numTf = new JTextField(10);
		nameTf = new JTextField(10);
		emailTf = new JTextField(10);
		phoneTf = new JTextField(10);

		
		conPan.add(BorderLayout.WEST, leftPan);
		conPan.add(BorderLayout.SOUTH, botPan);
		
		leftPan.add(leftInPan1);
		leftPan.add(leftInPan2);
		leftPan.add(leftInPan3);
		leftPan.add(leftInPan4);
		
		leftInPan1.add(numLabel);
		leftInPan2.add(nameLabel);
		leftInPan3.add(emailLabel);
		leftInPan4.add(phoneLabel);
		
		leftInPan1.add(numTf);
		leftInPan2.add(nameTf);
		leftInPan3.add(emailTf);
		leftInPan4.add(phoneTf);
		
		
		botPan.add(Btn1);
		botPan.add(Btn2);
		botPan.add(Btn3);
		botPan.add(Btn4);
		botPan.add(Btn5);

		test2();
	}

	private void test2() {
		colNames = new Object[] {"번호","이름","이메일","전화번호"};
		rowData = new Object[][] {
			{1, "카리나","Karina@naver.com","010-1111-1111"},
			{2, "윈터","Winter@naver.com","010-2222-2222"},
			{3, "지젤","Giselle@naver.com","010-3333-3333"},
			{4, "닝닝","Ningning@qq.com","010-4444-4444"},
		};
		
		dTable = new DefaultTableModel(rowData, colNames);
		table = new JTable(dTable);
		
		scrollPane = new JScrollPane(table);
		conPan.add(scrollPane);
		
	}
	
	public test2(String title, int Width, int Heigth) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("");
		setSize(Width,Heigth);
		
		Toolkit tk = this.getToolkit().getDefaultToolkit();
		int scrWidth = (int)tk.getScreenSize().getWidth();
		int scrHeigth = (int)tk.getScreenSize().getHeight();
		
		int x = scrWidth/2 - Width/2;
		int y = scrHeigth/2 - Heigth/2;
		
		this.setLocation(x,y);
		
		display();
	}
	
	private void settingClosing() {
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.out.println("프로세스 종료");
				dispose();
				System.exit(0);
			}
		});
	}
	
	protected void actionEvent() { 
	      Btn1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(test2.this,"전체보기");
			}
		   });
	      actionEvent1();
	      actionEvent2();
	      actionEvent3();
	      actionEvent4();
	   }	
	
	protected void actionEvent1() {
		   Btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog(test2.this,"이름을 입력해주세요(추가)");
			}
		   });
	   }
	
	protected void actionEvent2() {
		   Btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog(test2.this,"이름을 입력해주세요(삭제)");
			}
		   });
	   }
	
	protected void actionEvent3() {
		   Btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog(test2.this,"이름을 입력해주세요(검색)");
			}
		   });
	   }
	
	protected void actionEvent4() { 
	      Btn1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(test2.this,"취소");
			}
		   });
	}

	public static void main(String[] args) {
		new test2().setVisible(true);
	}
}