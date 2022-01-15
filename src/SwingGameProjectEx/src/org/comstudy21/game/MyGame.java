package org.comstudy21.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.comstudy21.game.component.AirPlan01;
import org.comstudy21.game.component.AirPlan02;
import org.comstudy21.game.component.BgImg;

public class MyGame extends JFrame implements Game, AppContext, KeyListener {
	private static final long serialVersionUID = -1477951982043838619L;
	public static AirPlan01 airPlan01 = new AirPlan01();
	public static AirPlan02 airPlan02 = new AirPlan02();
	public static BgImg bgImg = new BgImg();
	
	public static JPanel contentPan = new JPanel();
	
	public MyGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setContentPane(bgImg);
		contentPan = (JPanel) getContentPane();
		contentPan.add(bgImg);
		
		
		request.put("contentPane", bgImg);
		
		bgImg.setLayout(null);
		
		bgImg.add(airPlan01);

		setSize(900, 700);
	}

	@Override
	public void play() {
		
		bgImg.addKeyListener(this);
		
		setVisible(true);
		
		bgImg.setFocusable(true);
		bgImg.requestFocus();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		request.put("keyCode", keyCode);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		request.put("keyCode", 0);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
