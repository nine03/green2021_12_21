package org.comstudy21.notice.view;

import org.comstudy21.notice.R;
import org.comstudy21.notice.model.NoticeVo;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class


public class InsertView extends NoticeView {
	@Override
	public void display() {
		System.out.println("::::: 입력 기능 :::::");
		System.out.println("사용자 입력");
		String user = scan.next();
		System.out.print("메시지 입력>> ");
		String message = scan.next();
		
		
		LocalDateTime myDateObj = LocalDateTime.now();  
	    //System.out.println("Before formatting: " + myDateObj);  
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
	    
	    String formattedDate = myDateObj.format(myFormatObj);  
		R.noticeVo = new NoticeVo(0,user,message,formattedDate);
		System.out.println("입력 완료!");
	}
}
