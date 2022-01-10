package day19.guiex;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.Label;

public class Ex01Frame {

	public static void main(String[] args) {
		// 프레임 실행
		// 1. 단독으로 생성하기  
		// 2. 상속을 받아서 생성하기
		// 이렇게 만들면 외부에서 제어 해줘야한다.
		
		Frame frame = new Frame();
		
		frame.setLayout(new GridBagLayout());
		
		frame.setLayout(new FlowLayout());
		
		frame.add(new Label("Hello :"));
		frame.add(new Button("WORLD"));
		
		frame.setSize(640, 480); // 사이즈 조정
		frame.setVisible(true); // 화면이 보여짐
	}

}
