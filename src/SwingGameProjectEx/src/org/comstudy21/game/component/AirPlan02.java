package org.comstudy21.game.component;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.comstudy21.game.thread.AirPlan02Thread;
import org.comstudy21.game.thread.BuletThread;

public class AirPlan02 extends JPanel {
	//String url = "C:\\Users\\KBJ\\jsp-mvc-workspace\\SwingGameProjectEx\\src\\org\\comstudy21\\game\\component\\airplan02.png";
	Image img;
	
	int x=0, y=0, width=100, height=100;
	public AirPlan02() {
		//img = Toolkit.getDefaultToolkit().getImage(url);
		try {
			img = ImageIO.read(getClass().getResource("airplan02.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int x = 100 + (int)(Math.random()*700);
		AirPlan02Thread thread = new AirPlan02Thread(this, x, 0);
		thread.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, x, y, width, height, this);
	}
	
}
