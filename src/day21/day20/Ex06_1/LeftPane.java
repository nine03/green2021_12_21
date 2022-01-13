package day20.Ex06_1;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import static day20.Ex06_1.R.*;

public class LeftPane extends JPanel {
	String[] location = {"서울","경기도","강원도","충청도","전라도","경상도","황해도","함경도","평안도"};
	JComboBox<String> comboList = new JComboBox<String>(location);
	
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
		     
		      JPanel rowPan5 = new JPanel();
		      rowPan5.add(new JLabel("거주지 : "));
		      rowPan5.add(comboList);
				

		    
		      
		      bg.add(jrb1);
		      bg.add(jrb2);

		      JPanel rowPan6 = new JPanel();
		      rowPan6.add(jrb1);
		      rowPan6.add(jrb2);
				
				
		      JPanel rowPan7 = new JPanel();
		      rowPan7.add(man);
		      rowPan7.add(female);
		      
		      JPanel gridPan = new JPanel(new GridLayout(10, 1));
		      gridPan.add(rowPan1);
		      gridPan.add(rowPan2);
		      gridPan.add(rowPan3);
		      gridPan.add(rowPan4);
		      gridPan.add(rowPan5);
		      gridPan.add(rowPan6);
		      gridPan.add(rowPan7);
		      
		   
		      

	            
	      this.add(gridPan); 

	}
}
