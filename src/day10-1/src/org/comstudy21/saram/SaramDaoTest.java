package org.comstudy21.saram;

import org.comstudy21.saram.model.SaramDao;
import org.comstudy21.saram.model.SaramVo;

public class SaramDaoTest {
	public static SaramDao dao = new SaramDao();
	
	// DAO 테스트 delete
	public static void test_delete(String[] args) {
		dao.delete(new SaramVo(2, null, null, null));
		// 전체 출력
		test_selectAll(null);
	}
	
	// DAO 테스트 update
	public static void test_update(String[] args) {
		SaramVo vo = dao.selectByNo(3);
		// no는 주키이므로 변경하지 않는다.
		vo.setName("PARK2");
		vo.setPhone("010-3333-3300");
		vo.setEmail("park2@comstudy.org");
		dao.update(vo);
		
		SaramVo saram = dao.selectOne( new SaramVo(0, "PARK2", null, null) );
		System.out.println(saram);
	}
	
	// DAO 테스트 selectByNo
	public static void test_selectByNo(String[] args) {
		SaramVo saram = dao.selectByNo(3);
		System.out.println(saram);
	}

	// DAO 테스트 selectOne
	public static void test_selectOne(String[] args) {
		SaramVo vo = new SaramVo(0, "LEE", null, null);
		SaramVo saram = dao.selectOne(vo);
		System.out.println(saram);
	}
	
	// DAO 테스트 selectAll
	public static void test_selectAll(String[] args) {
		
		SaramVo[] saramArr = dao.selectAll();
		for(SaramVo saram : saramArr) {
			System.out.println(saram);
		}
	}

}
