package org.comstudy21.game.thread;

import java.util.Vector;

import javax.swing.JPanel;

import org.comstudy21.game.AppContext;
import org.comstudy21.game.component.AirPlan02;

public class AirPlan02Thread extends Thread implements AppContext {
	
	JPanel pane;
	
	int x, y, speed=10, bps=80;
	
	public AirPlan02Thread(JPanel pane, int x, int y) {
		this.pane = pane;
		this.x = x + 50;
		this.y = y;
	}
	
	@Override
	public void run() {
		while(true) {
			
			try {
				Thread.sleep(bps);
				y += speed;
				if(y >= 650 ) {
					pane.setVisible(false);
					JPanel contentPane = (JPanel)request.get("contentPane");
					contentPane.remove(pane);
					Vector<AirPlan02> airList = (Vector<AirPlan02>)request.get("airList");
					airList.remove(pane);
				}
				pane.setBounds(x,y,100,100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
