package day19.guiex;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 상속을 받은다음에 생성자안쪽에 넣어났다 
public class Ex02FrameEvent extends Frame implements WindowListener{
	public Ex02FrameEvent() {
		setTitle("WindowEventListener 실습");
		setSize(640,480);
		setVisible(true);
		
		this.addWindowListener(this);
	}
	
	public void windowClosing(WindowEvent e) {
		// 닫기 버튼 눌렀을때 창닫고 프로세스 끝내기
		System.out.println(">> 닫기 버튼을 눌렀기 때문에 프로세스가 종료된다!");
		dispose();
		System.exit(0); // 강제 종료 
	}
	public void windowOpened(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	
	public static void main(String[] args) {
		new Ex02FrameEvent();

	}
}
