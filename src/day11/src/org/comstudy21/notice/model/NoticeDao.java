package org.comstudy21.notice.model;

import java.util.Arrays;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class


public class NoticeDao {
	public static final int MAX = 100;
	private static final NoticeVo[] noticeArr = new NoticeVo[MAX];
	private static int top = 0;
	private static int noticeSeq = 1;
	
	
	static {
		LocalDateTime myDateObj = LocalDateTime.now();  
	    //System.out.println("Before formatting: " + myDateObj);  
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss");  
	    
	    String formattedDate = myDateObj.format(myFormatObj);
		noticeArr[top++] = new NoticeVo(noticeSeq++,"KIM","안녕하세요",formattedDate);
		noticeArr[top++] = new NoticeVo(noticeSeq++,"LEE","안녕",formattedDate);
		noticeArr[top++] = new NoticeVo(noticeSeq++,"PARK","이름이뭐예요",formattedDate);
	}
	
	
	// selectAll, selectOne, SelectByNo, update, delete, insert 구현 
	// selectAll
	public NoticeVo[] selectAll() {
			NoticeVo[] newArr = new NoticeVo[top];
			for(int i = 0; i < newArr.length; i++) {
				NoticeVo newNotice = new NoticeVo();
				newNotice.setNo(noticeArr[i].getNo());
				newNotice.setUser(noticeArr[i].getUser());
				newNotice.setMessage(noticeArr[i].getMessage());
				newNotice.setRegDate(noticeArr[i].getRegDate());
				newArr[i] = newNotice;
			}
			return newArr;
	}
	// selectOne
	public NoticeVo selectOne(NoticeVo vo) {
		for(int i =0; i < top; i++) {
			if(vo.getUser().equals(noticeArr[i].getUser())) {
				NoticeVo newNotice = new NoticeVo();
				newNotice.setNo(noticeArr[i].getNo());
				newNotice.setUser(noticeArr[i].getUser());
				newNotice.setMessage(noticeArr[i].getMessage());
				newNotice.setRegDate(noticeArr[i].getRegDate());
				return newNotice;
			}
		}
		return null;
	}
	// selsectByNo
	public NoticeVo selectByNo(int no) {
		for(int i = 0; i < top; i++) {
			if(no == noticeArr[i].getNo()) {
				NoticeVo newNotice = new NoticeVo();
				newNotice.setNo(noticeArr[i].getNo());
				newNotice.setUser(noticeArr[i].getUser());
				newNotice.setMessage(noticeArr[i].getMessage());
				newNotice.setRegDate(noticeArr[i].getRegDate());
				return newNotice;
			}
		}
		return null;
	}
	
	// search index
	public NoticeVo[] selectByWord(String s) {
		int count = 0;
		NoticeVo[] newnoticeArr = new NoticeVo[top];
		for(int i = 0; i < top; i++) {
			if(noticeArr[i].getMessage().indexOf(s) != -1) {
				NoticeVo newNotice = new NoticeVo();
				newNotice.setNo(noticeArr[i].getNo());
				newNotice.setUser(noticeArr[i].getUser());
				newNotice.setMessage(noticeArr[i].getMessage());
				newNotice.setRegDate(noticeArr[i].getRegDate());
				newnoticeArr[count++] = newNotice;
			}
		}
		if(count == 0) return null;
		else {
			NoticeVo[] outnoticeArr = new NoticeVo[count];
			for(int i = 0; i < count; i++) {
				outnoticeArr[i] = newnoticeArr[i];
			}
			return outnoticeArr;
		}
	}
	// insert
	public void insert(NoticeVo vo) {
		if(top >= MAX) {
			System.out.println(">>> 더이상 입력 불가능!");
			return;
		}
		vo.setNo(noticeSeq++);
		noticeArr[top++] = vo;
	}
	// update
	public void update(NoticeVo vo) {
		if(vo == null) return;
		for(int i = 0; i < top; i++) {
			if(noticeArr[i].getNo() == vo.getNo()) {
				noticeArr[i] = vo;
			}
		}
	}
	// delete
	public void delete(NoticeVo vo) {
		for(int i = 0; i < top; i++) {
			if(noticeArr[i].getNo() == vo.getNo()) {
				for(int j = i; j < top -1; j++) {
					noticeArr[j] = noticeArr[j+1]; 
				}
				noticeArr[top - 1] = null;
				top--;
			}
		}
	}
}
