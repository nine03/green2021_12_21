package day19.layout_Ex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import day19.guiex.myframe.MyFrame1;

public class LayoutEx00 extends MyFrame1 {
	
	public Button btn1 = new Button("BTN1");
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
	
	
	public LayoutEx00() {
		super("Layout Manager 연습",640,480);
		// flowLayoutEx();
		//gridLayoutEx();
		gridBagLayoutEx();
	}
	
	
	private void gridBagLayoutEx() {
		this.setLayout(new GridBagLayout());
		this.add(btn1);
		
	}


	private void gridLayoutEx() {
		this.setLayout(new GridLayout(3,2,5,5));
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btns.get(10));
	}


	public void flowLayoutEx() {
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
	
	public void borderLayoutEx() {
		add(BorderLayout.NORTH,btn1);
		add(BorderLayout.SOUTH,btn2);
		add(BorderLayout.WEST,btn3);
		add(BorderLayout.EAST,btn4);
		add(BorderLayout.CENTER,btn5);
	}
	
	
	public static void main(String[] args) {
		
		new LayoutEx00().setVisible(true); 
	}

}
