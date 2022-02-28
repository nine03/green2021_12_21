package org.comstudy21.saram.test;

import java.io.IOException;
import java.util.List;

import org.comstudy21.saram.model.SaramDao;
import org.comstudy21.saram.model.SaramDto;

public class SaramDaoTest {
   private static SaramDao saramDao = new SaramDao();
   
   public static void deleteTest() throws IOException {
      SaramDto dto = new SaramDto(7, "", "", 0);
      saramDao.delete(dto);
      selectAllTest();
   }
   
   public static void updateTest() throws IOException {
      SaramDto dto = new SaramDto(7, "KANG", "강길동", 16);
      saramDao.update(dto);
      selectAllTest();
   }
   
   public static void insertTest() throws IOException {
	      SaramDto dto = new SaramDto(0, "PARK2", "박길동2", 13);
	      saramDao.insert(dto);
	      selectAllTest();
	   }
   
   
   public static void insertTest1() throws IOException {
      SaramDto dto = new SaramDto(0, "PARK", "박길동", 14);
      saramDao.insert(dto);
      selectAllTest();
   }
   
   public static void selectOneTest() throws IOException {
      SaramDto saram = saramDao.selectOne(1);
      System.out.println(saram);
   }
   
   public static void selectAllTest() throws IOException {
      List<SaramDto> list = saramDao.selectAll();
      System.out.println(list);
   }

}