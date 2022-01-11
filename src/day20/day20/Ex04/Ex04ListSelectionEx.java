package day20.Ex04;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import day19.guiex.myframe.MyJFrame;

public class Ex04ListSelectionEx extends MyJFrame implements ListSelectionListener{

	  JList list;
	   JTextField tf;
	   
	   private void init() {
	      String[] str = {"등산","윈드서핑","독서","수영","골프","영화"};
	      list = new JList(str);
	      tf = new JTextField();
	   }
	   
	   protected void displayLayer() {
	      init();
	      this.add(new JLabel("취미를 선택하세요."), BorderLayout.NORTH);
	      this.add(list, BorderLayout.CENTER);
	      add(tf, BorderLayout.SOUTH);
	   }

	   protected void actionEvent() {
	      list.addListSelectionListener(this);
	   }
	   
	   public static void main(String[] args) {
	      new Ex04ListSelectionEx().setVisible(true);
	   }

	   public void valueChanged(ListSelectionEvent e) {
		// 리스트의 항목을 선택하면 실행 되는 이벤트 핸들러
	      Object[] item; // 아이템을 받을수 있도록 배열로 
	      String total = "";
	      
	      JList li = (JList)e.getSource();
	      item = li.getSelectedValues();
	      for(int i=0; i<item.length; i++) {
	         total = total + item[i] + " ";
	      }
	      
	      tf.setText("선택 된 항목 >> " + total);
	   }
	}