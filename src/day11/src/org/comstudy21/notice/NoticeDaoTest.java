package org.comstudy21.notice;

import org.comstudy21.notice.model.NoticeDao;
import org.comstudy21.notice.model.NoticeVo;

public class NoticeDaoTest {
	public static NoticeDao dao = new NoticeDao();
	
	// Dao 테스트 delete
	public static void main(String[] args) {
		dao.delete(new NoticeVo(2,null,null,null));
		test_selectAll(null);
	}
	
	// Dao 테스트 update
	public static void test_update(String[] args) {
		NoticeVo vo = dao.selectByNo(3);
		vo.setUser("PARK2");
		vo.setMessage("hi");
		vo.setRegDate("2001-07-08");
		dao.update(vo);
		
		NoticeVo notice = dao.selectOne(new NoticeVo(0,"PARK2",null,null));
		System.out.println(notice);
	}
	
	
	// Dao 테스트 selectByNo
	public static void test_selectByNo(String[] args) {
		NoticeVo notice = dao.selectByNo(3);
		System.out.println(notice);
	}
	
	// Dao 테스트 selectAll
	public static void test_selectOne(String[] args) {
		NoticeVo vo = new NoticeVo(0,"LEE",null,null);
		NoticeVo notice = dao.selectOne(vo);
		System.out.println(notice);
	}
	
	// Dao 테스트 selectAll
	public static void test_selectAll(String[] args) {
		NoticeVo[] noticeArr = dao.selectAll();
		for(NoticeVo notice : noticeArr) {
			System.out.println(notice);
		} 
	}
}
