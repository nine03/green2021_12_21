package day19.guiex2;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex02FrameEvent extends Frame implements WindowListener{
	
	public Ex02FrameEvent() {
		setTitle("WindoeEventListener 실습");
		setSize(680,480);
		setVisible(true);
		
		this.addWindowListener(this);
	}
	
	
	
	
	public void windowClosing(WindowEvent e) {
		System.out.println(">> 닫기 버튼을 눌렀기 떄문에 프로세스가 종료된다!");
		dispose();
		System.exit(0);
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
