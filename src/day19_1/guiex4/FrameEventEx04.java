package day19.guiex4;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameEventEx04 extends Frame {
	public FrameEventEx04() { // 생성자 
		setTitle("익명 내부 클래스를 활용한 이벤트 핸들러 구현");
		setSize(640,480);
		setVisible(true);
		
		
		// 인터페이스를 구현 하면서 인스턴스 생성 가능 (익명 내부 클래스 객체)
		// 1회용으로 사용이 끝난다.
		//addWindowListener(class implement new WindowListener()
		addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}	
			public void windowDeiconified(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {
				// FrameEventEx04.this.dispose();  원래 정석은 이거 
				dispose();
				System.exit(0);
			}
			public void windowClosed(WindowEvent e) {}
			public void windowActivated(WindowEvent e) {}
		});
	}
	
	public static void main(String[] args) {
		new FrameEventEx04();
	}

}
