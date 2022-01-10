package day19.guiex3;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameEventEx03 extends Frame {
	
	public int width = 640, height = 480;
	public FrameEventEx03() { // 생성자 만들기 
		setTitle("Inner class를 활용한 이벤트 처리 연습");
		setSize(width,height);
		setVisible(true);
		
		WindowListener l = new InnerWindowListener();
		addWindowListener(l);
	}
	
	// 클래스 내부에 클래스를 선언한다. (매우 중요!)
	class InnerWindowListener implements WindowListener {
		public void windowOpened(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {
			if(width == 100) {
				dispose();
				System.exit(0);
			}
			FrameEventEx03.this.width = 100;
			FrameEventEx03.this.height = 100;
			setSize(width,height);
			
		}
		public void windowClosed(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowActivated(WindowEvent e) {}
		public void windowDeactivated(WindowEvent e) {}
	}
	public static void main(String[] args) {
		new FrameEventEx03(); 

	}
}
