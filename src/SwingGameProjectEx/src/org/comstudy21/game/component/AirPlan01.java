package org.comstudy21.game.component;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.comstudy21.game.thread.AirPlan01Thread;

public class AirPlan01 extends JPanel {
	//String url = "C:\\Users\\KBJ\\jsp-mvc-workspace\\SwingGameProjectEx\\src\\org\\comstudy21\\game\\component\\airplan01.png";
	Image img;
	
	int x=0, y=0, width=150, height=150;
	public AirPlan01() {
		//img = Toolkit.getDefaultToolkit().getImage(url);
		try {
			img = ImageIO.read(getClass().getResource("airplan01.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		AirPlan01Thread gameThread = new AirPlan01Thread(this, 350, 490, 10, 30);
		gameThread.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, x, y, width, height, this);
	}
}
