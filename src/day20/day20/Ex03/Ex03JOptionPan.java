package day20.Ex03;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import day19.guiex.myframe.MyJFrame;

public class Ex03JOptionPan extends MyJFrame {
   JButton openBtn,btn2,btn3,btn4;
   String[] str={"가입하기", "다시쓰기", "취소"};
   
   public Ex03JOptionPan() {
	super("show dialog example",400,400);
}
   
   protected void init() {
      openBtn = new JButton("message 열기");
      btn2 = new JButton("input Dialog 열기");
      btn3 = new JButton("confirm Dialog 열기");
      btn4 = new JButton("Option 창 열기");
   }
   
   protected void displayLayer() {
      init();
      contentPan = getContentPane();
      contentPan.setLayout(new GridBagLayout());
      JPanel main = new JPanel(new GridLayout(4,1,5,5));
      contentPan.add(main);
      main.add(openBtn);
      main.add(btn2);
      main.add(btn3);
      main.add(btn4);
   }
   
   protected void actionEvent() { // super에서 호출해줘야한다 .
      openBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // 버튼을 클릭하면 다이얼로그 창 보이게 하기
            JOptionPane.showMessageDialog(Ex03JOptionPan.this, "환영합니다!");
         }
      });
      
      actionEvent1(); // 호출을 해줘야한다 
      actionEvent2();
      actionEvent3();
   }
   
   protected void actionEvent1() {
	   btn2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showInputDialog(Ex03JOptionPan.this,"아이디를 입력하시오");
		}
	   });
   }
   //ppt 9장 보기 
   
   protected void actionEvent2() {
	   btn3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showConfirmDialog(Ex03JOptionPan.this,"작업을 종료하시겠습니까?");
		}
	   });
   }
   
   protected void actionEvent3() {
	   btn4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showOptionDialog(Ex03JOptionPan.this,"원하는 작업을 선택하시오.", "대화상자",
					  JOptionPane.YES_NO_CANCEL_OPTION,     
					  JOptionPane.INFORMATION_MESSAGE,
					  null, str, str[0]);
		}
	   });
   }
   
   public static void main(String[] args) {
      new Ex03JOptionPan().setVisible(true);
   }

   public static void test01(String[] args) {
      JOptionPane.showMessageDialog(null, "Hello world!");
   }

}