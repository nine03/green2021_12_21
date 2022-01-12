package day20.Ex05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class test1 extends Frame {
	
	public int width = 640, height = 480;
	
	Panel innerPan = new Panel(new GridLayout(7,0,0,20));
	Panel textarea= new Panel(new FlowLayout());
	
	
	Panel PS = new Panel(new GridLayout(8,1));
	Panel SS = new Panel( new FlowLayout() );
	Panel CS = new Panel( new FlowLayout() );
	
	
	
	JLabel numberLabel = new JLabel("번호       ");
	JLabel nameLabel = new JLabel("이름       ");
	JLabel emailLabel = new JLabel("이메일    ");
	JLabel phoneLabel = new JLabel("전화번호");
	
	Panel numberGrid = new Panel();
	Panel nameGrid = new Panel();
	Panel emailGrid = new Panel();
	Panel phoneGrid = new Panel();

	TextField Number = new TextField(15);
	TextField name = new TextField(15);
	TextField email = new TextField(15);
	TextField phone = new TextField(15);
	
	TextArea area = new TextArea("", 30, 60, 3);
	
	
	public test1() 
	{
		super.setTitle(" ");
		super.setSize( width, height);
		
		settingCenter();
		settingClosing();
		setBackground(Color.LIGHT_GRAY);
		add(BorderLayout.LINE_START, PS);
		add(BorderLayout.CENTER, CS);
		
		CS.add(area);
		
		PS.add(numberGrid);
		numberGrid.add(numberLabel);
		numberGrid.add(Number);
		
		PS.add(nameGrid);
		nameGrid.add(nameLabel);
		nameGrid.add(name);
		
		PS.add(emailGrid);
		emailGrid.add(emailLabel);
		emailGrid.add(email);
		
		PS.add(phoneGrid);
		phoneGrid.add(phoneLabel);
		phoneGrid.add(phone);
		
		add(BorderLayout.SOUTH, SS);
		SS.add( new JButton(" 전체보기 ") );
		SS.add( new JButton(" 추  가  ") );
		SS.add( new JButton(" 삭  제  ") );
		SS.add( new JButton(" 검  색  ") );
		SS.add( new JButton(" 취  소  ") );
	}
	
private void settingCenter() {
		
		Toolkit tk = this.getToolkit().getDefaultToolkit();
		int scrWidth = (int)tk.getScreenSize().getWidth();
		int scrHeight = (int)tk.getScreenSize().getHeight();
		int x = scrWidth/2 - width /2;
		int y = scrHeight/2 - height /2;
		this.setLocation(x,y);
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
	
	public static void main(String[] args) {
		new test1().setVisible(true);
	}

}
