package day19.layout_Ex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import day19.guiex.myframe.MyFrame;

public class LayoutEx01 extends MyFrame {
	
	public Button btn1 = new Button("BTN1"); // 필드에 버튼은 만듬
	public Button btn2 = new Button("BTN2");
	public Button btn3 = new Button("BTN3");
	public Button btn4 = new Button("BTN4");
	public Button btn5 = new Button("BTN5");
	
	public ArrayList<Button> btns = new ArrayList<Button>(); 
	{
		for(int i = 0; i < 100; i++) {
			btns.add(new Button("BTN" + i));
		}
	}
	
	
	public LayoutEx01() {
		super("Layout manager 연습",640,480); 
		// flowLayoutEx();
		// gridLayoutEx();
		gridBagLayoutEx();
	}
	
	private void gridBagLayoutEx() {
		this.setLayout(new GridBagLayout());
		this.add(btn1); // 정가운데 
		
	}

	public void gridLayoutEx(){
		this.setLayout(new GridLayout(3,2,5,5));
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btns.get(10));
	}
	
	public void flowLayoutEx() {
		// FlowLayout - 왼쪽에서 오른쪽으로 순서대로 붙인다.
		this.setLayout(new FlowLayout());
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		
		for(Button btn : btns) {
			this.add(btn);
		}
		
	}

	public void borderLayoutEx() { // 생성자
		//super("Layout manager 연습",640,480); // 생성자 호출
		// Window를 상속받은 Frame은 디폴트 레이아웃이 BorderLayout
		//add(btn1); // 위치를 내가 지정해주지않으면 무조건 센터 
		//add("North",btn1);
		add(BorderLayout.NORTH,btn1);
		add(BorderLayout.SOUTH,btn2);
		add(BorderLayout.WEST,btn3);
		//add(BorderLayout.EAST,btn4);
		add(BorderLayout.CENTER,btn5);
	}
	public static void main(String[] args) {
		
		// 화면에 보이는 설정 맨 마지막에 해 준다.
		new LayoutEx01().setVisible(true); // 다준비하고 마지막에 보여주는게 좋다 
	}

}
