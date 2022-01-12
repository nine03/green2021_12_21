package day20.Ex06_1;


import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import static day20.Ex06_1.R.*;

public class LeftPane extends JPanel {
	
	
	public LeftPane() { 
			  
		
		      JPanel rowPan1 = new JPanel();
		      rowPan1.add(new JLabel("아이디 : "));
		      rowPan1.add(txtFld1);
		      JPanel rowPan2 = new JPanel();
		      rowPan2.add(new JLabel("사용자 : "));
		      rowPan2.add(txtFld2);
		      JPanel rowPan3 = new JPanel();
		      rowPan3.add(new JLabel("이메일 : "));
		      rowPan3.add(txtFld3);
		      JPanel rowPan4 = new JPanel();
		      rowPan4.add(new JLabel("핸드폰 : "));
		      rowPan4.add(txtFld4);
		      
		      JPanel gridPan = new JPanel(new GridLayout(5, 1));
		      gridPan.add(rowPan1);
		      gridPan.add(rowPan2);
		      gridPan.add(rowPan3);
		      gridPan.add(rowPan4);

	      
	      this.add(gridPan); 

	}
}