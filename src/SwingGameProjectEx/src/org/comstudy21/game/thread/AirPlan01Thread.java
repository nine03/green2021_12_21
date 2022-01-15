package org.comstudy21.game.thread;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JPanel;

import org.comstudy21.game.AppContext;
import org.comstudy21.game.MyGame;
import org.comstudy21.game.component.AirPlan02;
import org.comstudy21.game.component.Bulet;

public class AirPlan01Thread extends Thread implements AppContext {
	private JPanel pane;
	
	int x = 0;
	int y = 0;
	int speed = 10;
	int bps = 50;
	
	Vector<AirPlan02> airList = new Vector<>();
	Vector<Bulet> buletList = new Vector<>();	
	
	public AirPlan01Thread(JPanel pane, int x, int y, int speed, int bps) {
		this.pane = pane;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.bps = bps;
		
		request.put("airList", airList);
		request.put("buletList", buletList);
	}
	
	@Override
	public void run() {
		int cnt=0;
		JPanel contentPane = (JPanel)request.get("contentPane");
		while(true) {
			try {
				Thread.sleep(bps);
				int keyCode = (int)((request.get("keyCode")==null ? 0 :request.get("keyCode")  ));
				if(keyCode == KeyEvent.VK_LEFT) {
					x -= speed;
				} if(keyCode == KeyEvent.VK_RIGHT) {
					x += speed;
				}  
				pane.setBounds(x, y, 150, 150);
				
				request.put("airPlan01X", x);
				
				if(cnt % 10 == 0) {
					Bulet bulet = new Bulet();
					buletList.add(bulet);
					contentPane.add(bulet);
				}
				
				if(cnt % 23 == 0) {
					AirPlan02 airPlan02 = new AirPlan02();
					airList.add(airPlan02);
					contentPane.add(airPlan02);
				}
				
				if(cnt % 5 == 0) {
					for(int i=0; i<airList.size(); i++) {
						AirPlan02 air = airList.get(i);
						int airX1 = air.getX();
						int airX2 = air.getX() + air.getWidth();
						int airY1 = air.getY();
						int airY2 = air.getY() + air.getHeight();
						
						for(int j=0; j<buletList.size(); j++) {
							Bulet bulet = buletList.get(j);
							int bcX = bulet.getX() + (bulet.getWidth()/2);
							int bcY = bulet.getY() + (bulet.getHeight()/2);
							
							if((bcX>=airX1&&bcX<=airX2)&&(bcY>=airY1&&bcY<=airY2)) {
								contentPane.remove(air);
								contentPane.remove(bulet);
								airList.remove(air);
								buletList.remove(bulet);
								MyGame.bgImg.repaint();
							}
						}
					}
				}
				
				//System.out.println("airList.size() => " + airList.size());
				
				cnt++;
				if(cnt >= 10001) {
					cnt=0;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
