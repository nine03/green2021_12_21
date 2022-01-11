package day20.Ex01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import day19.guiex.myframe.MyFrame;

public class Ex03 extends MyFrame {
	   Panel leftPan = new Panel(); // 패널 생성 
	   Panel centerPan = new Panel(new GridBagLayout());
	   Button btn1 = new Button("button 01"); //버튼 생성 
	   TextField txtFld = new TextField(10);
	   TextField txtFld2 = new TextField(10);
	   TextField txtFld3 = new TextField(10);
	   TextField txtFld4 = new TextField(10);
	   public Ex03() { // 생성자  
	      super("Member management system", 640, 480);
	      
	      add(BorderLayout.WEST, leftPan);
	      add(BorderLayout.CENTER, centerPan);
	      
	      centerPan.add(new Label("center message"));
	      centerPan.setBackground(Color.BLUE);
	      
	      Panel rowPan1 = new Panel();
	      rowPan1.add(new Label("btn01 : "));
	      rowPan1.add(btn1);
	      Panel rowPan2 = new Panel();
	      rowPan2.add(new Label("text01 : "));
	      rowPan2.add(txtFld);
	      Panel rowPan3 = new Panel();
	      rowPan3.add(new Label("text02 : "));
	      rowPan3.add(txtFld2);
	      Panel rowPan4 = new Panel();
	      rowPan4.add(new Label("text03 : "));
	      rowPan4.add(txtFld3);
	      Panel rowPan5 = new Panel();
	      rowPan5.add(new Label("text04 : "));
	      rowPan5.add(txtFld4);
	      
	      Panel gridPan = new Panel(new GridLayout(5, 1)); //5 행 1열 
	      gridPan.add(rowPan1);
	      gridPan.add(rowPan2);
	      gridPan.add(rowPan3);
	      gridPan.add(rowPan4);
	      gridPan.add(rowPan5);
	      
	      leftPan.add(gridPan); // 레프트 펜 꽉찾기 때문에 
	    //플로웃 아웃은 옆으로 계속 붙는다 
	   }
	   
	   public static void main(String[] args) {
	      new Ex03().setVisible(true);
	   }
	}