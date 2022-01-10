package day19.guiex2;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class MyWindowListener implements WindowListener {

	FrameEventEx02 target;
	public MyWindowListener(FrameEventEx02 target) { // 생성자를 만들어주기 
		this.target = target; // 제어권을 넘어주면된다 
	}
	public void windowOpened(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {
		System.out.println(">>> 닫기 버튼 누름 .. 프로세스 종료!");
		target.dispose();
		System.exit(0);
	}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	
}

public class FrameEventEx02 extends Frame{
	public static final int WIDTH = 600, HEIGHT = 400;	
	public FrameEventEx02() {
		setTitle("이벤트 리스트 연습");
		setSize(WIDTH,HEIGHT);
		setVisible(true);
		
		WindowListener l = new MyWindowListener(this);
		addWindowListener(l);
	}
	
	
	public static void main(String[] args) {
		new FrameEventEx02();
	}

}
