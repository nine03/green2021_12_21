package day19.guiex.myframe;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame { // 생성자 
   
	// 디폴트 생성자 
	public MyFrame() {
		
		// 생성자 오버로딩 호출 
      this("my-frame",200,200);
   }

// 생성자 오버로딩 
   public MyFrame(String title, int w, int h) { // 생성자 이용 
      this.setTitle(title); // this 생략
      super.setSize(w, h);
      
      // 이벤트 핸들러
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            dispose();
            System.exit(0);
         }
      });
      
      // 스크린 화면의 정 가운데 배치 
      // toolkit 가운데 정렬 
      Toolkit tk = this.getToolkit().getDefaultToolkit();
      int scrWidth = (int)tk.getScreenSize().getWidth();
      int scrHeight = (int)tk.getScreenSize().getHeight();
      int x = scrWidth/2 - w/2;
      int y = scrHeight/2 - h/2;
      this.setLocation(x, y);
   }
}