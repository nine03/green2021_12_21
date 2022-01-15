package org.comstudy21.game.thread;

import java.util.Vector;

import javax.swing.JPanel;

import org.comstudy21.game.AppContext;
import org.comstudy21.game.component.AirPlan02;
import org.comstudy21.game.component.Bulet;

public class BuletThread extends Thread implements AppContext {
	
	JPanel pane;
	
	int x, y, speed=20, bps=30;
	
	public BuletThread(JPanel pane, int x, int y) {
		this.pane = pane;
		this.x = x + 50;
		this.y = y - 50;
	}
	
	@Override
	public void run() {
		while(true) {
			
			try {
				Thread.sleep(bps);
				y -= speed;
				if(y < 0 ) {
					pane.setVisible(false);
					JPanel contentPane = (JPanel)request.get("contentPane");
					contentPane.remove(pane);
					Vector<Bulet> buletList = (Vector<Bulet>)request.get("buletList");
					buletList.remove(pane);
				}
				pane.setBounds(x,y,50,100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
