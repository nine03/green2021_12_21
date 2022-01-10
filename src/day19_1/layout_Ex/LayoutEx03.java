package day19.layout_Ex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import day19.guiex.myframe.MyFrame;

public class LayoutEx03 extends MyFrame implements ActionListener {
	
	// Panel을 이용한 세부 레이아웃 설정
	Panel centerPan = new Panel(new GridBagLayout());
	Label centerLbl = new Label("Hello Java World!");
	Panel southPan = new Panel(new GridLayout(1, 3));
	Panel innerPan = new Panel(new GridLayout(2,1));
	Button btn1 = new Button("BTN1");
	Button btn2 = new Button("BTN2");
	Button btn3 = new Button("BTN3");
	Button btn4 = new Button("BTN4");
	public LayoutEx03() { // 생성자 만들기 
		layoutEx01(); // 함수
	}
	
	public void layoutEx01() { // 함수선언
		// 센터에 붙인다.
		this.add(BorderLayout.CENTER,centerPan);
		centerPan.add(centerLbl);
		// 하단에 붙인다 
		southPan.add(btn1);
		southPan.add(btn2);
		southPan.add(innerPan);
		innerPan.add(btn3);
		innerPan.add(btn4);
		this.add(BorderLayout.SOUTH,southPan);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
	
	}
	
	public static void main(String[] args) {
		new LayoutEx03().setVisible(true);
		
	}

	   @Override
	   public void actionPerformed(ActionEvent e) {
	      // 제어문을 이용해서 버튼을 선별한다.
	       if (e.getSource() instanceof Button) {
	         Button btn = (Button)e.getSource();
	         if(btn1.equals(btn)) {
	            System.out.println("btn1 눌렀다");
	            centerLbl.setText("press btn1");
	         } else if(btn2.equals(btn)) {
	            System.out.println("btn2 눌렀다");
	            centerLbl.setText("press btn2");
	         } else if(btn3.equals(btn)) {
	            System.out.println("btn3 눌렀다");
	            centerLbl.setText("press btn3");
	         } else if(btn4.equals(btn)) {
	            System.out.println("btn4 눌렀다");
	            centerLbl.setText("press btn4");
	         } 
	      }
	   }
	}
