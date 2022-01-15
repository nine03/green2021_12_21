package org.comstudy21.game.component;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.comstudy21.game.AppContext;
import org.comstudy21.game.thread.BuletThread;

public class Bulet extends JPanel implements AppContext {
	//String url = "C:\\Users\\KBJ\\jsp-mvc-workspace\\SwingGameProjectEx\\src\\org\\comstudy21\\game\\component\\bulet.png";
	Image img;
	
	int x=0, y=0, width=50, height=100;
	public Bulet() {
		//img = Toolkit.getDefaultToolkit().getImage(url);
		try {
			img = ImageIO.read(getClass().getResource("bulet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int x = (int)request.get("airPlan01X");
		BuletThread thread = new BuletThread(this, x, 600);
		thread.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, x, y, width, height, this);
	}
	
}
