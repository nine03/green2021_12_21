package day20.Ex02;

import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.*;


public class GridLayoutEx extends JFrame{

	
	public GridLayoutEx() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(4,2);
		grid.setVgap(0);
		Container c = getContentPane();
		
		c.setLayout(grid);
		
		c.add(new JLabel("이 름:"));
		c.add(new JTextField(15));
		
		c.add(new JLabel("아 이 디:"));
		c.add(new JTextField(15));
		
		c.add(new JLabel("패스워드:"));
		c.add(new JTextField(15));
		
		c.add(new JLabel("나 이:"));
		c.add(new JTextField(15));

		setSize(300,200);
		setVisible(true);
		
		Container contentPan  = getContentPane();
		contentPan.setLayout(new FlowLayout());
		
		contentPan.add(new JButton("가입하기"));
		contentPan.add(new JButton("다시쓰기"));
		setSize(300,150);
	}
	public static void main(String[] args) {
		new GridLayoutEx();
	}
}
