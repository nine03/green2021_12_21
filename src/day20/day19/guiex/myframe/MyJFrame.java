package day19.guiex.myframe;

import java.awt.Container;

import javax.swing.JFrame;


// 추상메소드
public abstract class MyJFrame extends JFrame {

	protected Container contentPan = null;
	
	public MyJFrame() {
//		// 닫기 버튼 눌를때 강제종료 이벤트 처리 
//				setDefaultCloseOperation(EXIT_ON_CLOSE);
//				
//				// 타이틀 지정 
//				// 스윙은 한글이 된다 
//				setTitle("첫번째 스윙 실습");
//				// 크기 설정 
//				setSize(640,480);
		
		this("my JFrame",200,200);
	}

	public MyJFrame(String title, int w, int h) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(title);
		setSize(w, h);
		
		displayLayer(); // 동적바인딩
		actionEvent();
	}
	// 추상 메소드 
	protected abstract void displayLayer(); // 레이아웃 잡고 
	protected abstract void actionEvent();  // 이벤트 핸들러 잡을수 있다
}
