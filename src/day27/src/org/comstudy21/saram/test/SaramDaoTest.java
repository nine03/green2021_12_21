package org.comstudy21.saram.test;

import java.util.List;

import org.comstudy21.saram.model.SaramDao;
import org.comstudy21.saram.model.SaramDto;

public class SaramDaoTest {

	public static void main(String[] args) {
		 testSaramSelectAll();
		// testSelectOne();
		// testInsert();
		// testUpdate();
		// testDelete();
		// testSelectByName();
		  testSelectById();
		
	}
	private static void testSelectById() {
		SaramDto saram = SaramDao.selectById(new SaramDto(1,"KIM",null,0));
		System.out.println(saram.toString());
	}
	private static void testSelectByName() {
		List<SaramDto> list = SaramDao.selectByName(new SaramDto(1,null,"Yeongjun",0)); // 대소문자 구분해야됨
		for(SaramDto saram : list) {
			System.out.println(saram);
		}
		
	}
	private static void testDelete() {
		SaramDto dto = new SaramDto(1,null,null,0);
		SaramDao.delete(dto);
		testSaramSelectAll();
		
	}
	private static void testUpdate() { 
		SaramDto dto = new SaramDto(3,"KIM","Yeongjun",32);
		SaramDao.update(dto);
		testSaramSelectAll();
	}
	private static void testInsert() {
		SaramDao.insert(new SaramDto(0,"test1","Yeongjun",15));
		
		
	}
	private static void testSelectOne() {
		SaramDto saram = SaramDao.selectOne(new SaramDto(1,null,null,0));
		System.out.println(saram.toString());
	}

	private static void testSaramSelectAll() {
		List<SaramDto> list = SaramDao.selectAll();
		for(SaramDto saram : list) {
			System.out.println(saram);
		}
		
	}

}
