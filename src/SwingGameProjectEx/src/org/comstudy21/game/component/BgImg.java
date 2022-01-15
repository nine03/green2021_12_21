package org.comstudy21.game.component;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BgImg extends JPanel {
	//String url = "C:\\Users\\KBJ\\jsp-mvc-workspace\\SwingGameProjectEx\\src\\org\\comstudy21\\game\\component\\img_sky01.jpg";
	Image img;
	
	int x=0, y=0, width=900, height=675;
	public BgImg() {
		//img = Toolkit.getDefaultToolkit().getImage(url);
		try {
			img = ImageIO.read(getClass().getResource("img_sky01.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, x, y, width, height, this);
	}
	
}
