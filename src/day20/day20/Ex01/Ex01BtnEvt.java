package day20.Ex01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import day19.guiex.myframe.MyFrame;

public class Ex01BtnEvt extends MyFrame{
	
	private Button[] btnArr = new Button[2]; 
	{
		// 초기화 블럭  - 필드를 초기화 하는 구역
		btnArr[0] = new Button("Button1");
		btnArr[1] = new Button("Button2");
	}   // 실행문은 메소드 안에서 
	
	private Label lbl = new Label("[Result] No button pressed"); // 라벨 

	public Ex01BtnEvt() {
		super("Button Event Ex",400,150); // 넓이 높이
		start(); // 레이아웃 
		run(); // 이벤트 
	}
	
	// 이벤트 처리 
	private void run() { // run 메소드 생성 
		// 익명 내부 클래스를 이용한 이벤트 핸들러 처리 
		btnArr[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl.setText("[Result] First Button pressed");
				// 버튼 열개 이하이면 이런 방법이 효율이 높다 
				
				// 배경색 바꾸는 방법 
				//out.println(Ex01BtnEvt.this);
			//Button btn = (Button)(e.getSource());
			//btn.setBackground(Color.BLUE);
			
			// this는 패널 이용해서 색깔을 바꿔야한다. 
			// Ex01BtnEvt.this.setBackground(Color.RED);
				
			}
		});
		
		btnArr[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl.setText("[Result] Second Button pressed");
				// 버튼 열개 이하이면 이런 방법이 효율이 높다 
			}
		});
	}

	// 레이아웃 
	public void start() { // 메소드 
		Panel southPan = new Panel(); // 패널 만들기 패널의 디폴트 레이아웃 
		// Panel의 Default Layout은 FlowLayout 
		// 어디가 붙이는지 제대로 알아야한다 번지를 제대로 붙여라 
		Panel centerPan = new Panel(new GridBagLayout());
		southPan.add(btnArr[0]);
		southPan.add(btnArr[1]);
		centerPan.add(lbl);
		this.add(BorderLayout.SOUTH,southPan);
		this.add(BorderLayout.CENTER,centerPan);
	}

	
	// 버튼에 이벤트 붙이는 방법 
	// 라벨에 
	// add.액션 리스너 
	// 버튼 
	public static void main(String[] args) {
		new Ex01BtnEvt().setVisible(true);
	}

}


// 돈많이 번이유는 코가콜라  확실한거에만 투자한다.
// 노력보다는 방법적인 문제 
// 패러다임 
// 절차적 프로그램 
// 패치 프로세스 
// 객 제지향은 객체가 중심이다. 
// 데이터가 주가된다 .
// 방법이 바뀐다.