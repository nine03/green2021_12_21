package day19.guiex;

import java.awt.Frame;

public class Ex01Frame {

	public static void main(String[] args) {
		// 프레임 실행
		// 단독으로 생성하기 / 상속을 받아서 생성하기
		// 이렇게 만들면 외부에서 제어 해줘야한다.
		Frame frame = new Frame();
		frame.setSize(640, 480); // 사이즈 조정
		frame.setVisible(true); // 화면이 보여짐
	}

}
