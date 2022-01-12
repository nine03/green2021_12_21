package day20.Ex06_1;

import javax.swing.JButton;
import javax.swing.JPanel;

import static day20.Ex06_1.R.*;

public class BottomPane extends JPanel {
	
	public BottomPane() {
		this.add(allBtn);
		this.add(inputBtn);
		this.add(searchBtn);
		this.add(modifyBtn);
		this.add(deleteBtn);
		this.add(finishBtn);
	}
}
