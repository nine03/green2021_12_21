package day20.Ex02;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import day19.guiex.myframe.MyJFrame;

public class Ex02MyJFrameTest1 extends MyJFrame{
	
	 
	JButton okBtn, resetBtn;
	JTextField txtFld1, txtFld2, txtFld3, txtFld4;
	JPanel centerPan, leftPan, mainPan, bottomPan;
	
	public Ex02MyJFrameTest1() {
		super("회원가입",300,250);
	}
	
	 public void init() {
	      okBtn = new JButton("가입하기");
	      resetBtn = new JButton("다시작성");
	      txtFld1 = new JTextField(20);
	      txtFld2 = new JTextField(20);
	      txtFld3 = new JTextField(20);
	      txtFld4 = new JTextField(20);
	      centerPan = new JPanel(new BorderLayout());
	      leftPan = new JPanel(new GridLayout(4, 1));
	      mainPan = new JPanel(new GridLayout(4, 1));
	      bottomPan = new JPanel();
	   }
	   
	   @Override
	   protected void displayLayer() {
	      init();
	      // MyJFrame에 필드로 선언 되었다. Container contentPan
	      contentPan = getContentPane();
	      centerPan.setSize(120, 200);
	      contentPan.setLayout(new GridBagLayout());
	      contentPan.add(centerPan);
	      centerPan.add(BorderLayout.WEST, leftPan);
	      centerPan.add(BorderLayout.CENTER, mainPan);
	      centerPan.add(BorderLayout.SOUTH, bottomPan);
	      leftPan.add(new JLabel("성      명:"));
	      leftPan.add(new JLabel("아  이  디:"));
	      leftPan.add(new JLabel("패스워드:"));
	      leftPan.add(new JLabel("나      이:"));
	      mainPan.add(txtFld1);
	      mainPan.add(txtFld2);
	      mainPan.add(txtFld3);
	      mainPan.add(txtFld4);
	      bottomPan.add(okBtn);
	      bottomPan.add(resetBtn);
	   }

	   @Override
	   protected void actionEvent() {
	      
	   }
	   
	   public static void main(String[] args) {
	      new Ex02MyJFrameTest1().setVisible(true);
	   }

	}


