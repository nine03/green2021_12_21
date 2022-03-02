package org.comstudy21.myapp;

import java.io.IOException;
import java.util.List;

import org.comstudy21.myapp.saram.model.SaramDao;
import org.comstudy21.myapp.saram.model.SaramDto;
import org.junit.*;

public class SaramDaoTest {
	
	private SaramDao saramDao = new SaramDao();
	
	@Test
	public void selectAll() throws IOException {
		List<SaramDto> list = saramDao.selectAll();
		for(int i =0;i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
//	@Test
//	public void insertTest() {
//		SaramDto saram = new SaramDto(0,"Test","Mybatis",0);
//		saramDao.insert(saram);
//	}

}
