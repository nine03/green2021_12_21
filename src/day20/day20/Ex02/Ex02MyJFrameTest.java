package day20.Ex02;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import day19.guiex.myframe.MyJFrame;

public class Ex02MyJFrameTest extends MyJFrame{
	
	// 필드
	// 상속을 받으면 부모를 먼저 호출하고 상속을 받는다 부모가  없는 멤버는 접근할수가없다 
	Button btn;   
	
	//protected Container contentPan = null; // 상속받을려면 protected
	
	public void init() {
		btn = new Button("Hello");
	}
	
	// 부모 생성자에서 호출 displayLayer()
	@Override
	protected void displayLayer() {  // 레이아웃 
		init(); // 이렇게 호출해줄수있다 
		// MyJFrame에 필드로 선언 되었다. Container 타입으로 Container contentPan
		//contentPan  = getContentPane(); // 리턴하는 타입이 컨테이너 
		
		//contentPan.add(BorderLayout.SOUTH, new Button("Hello"));
		//grid.setVgap(0);
		
		contentPan  =  getContentPane();
		contentPan.add(BorderLayout.SOUTH, btn);
		
		// contentPan.add(BorderLayout.SOUTH, btn); 요렇게하면 null point  발생한다
		
	}
	
	@Override
	protected void actionEvent() { // 이벤트 핸들러 
		
	}

	public static void main(String[] args) {
			//new Ex02MyFHrameTest().setVisible(true);
			new Ex02MyJFrameTest().setVisible(true);
	}
}


// 쭉같다 붙이고 조정만하면된다 