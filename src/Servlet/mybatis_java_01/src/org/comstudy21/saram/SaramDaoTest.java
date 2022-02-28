package org.comstudy21.saram;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.comstudy21.saram.model.SaramDto;

public class SaramDaoTest {
   
   public static void main(String[] args) throws IOException {
      String resource = "mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

      try (SqlSession mybatis = sqlSessionFactory.openSession()) {
         List<SaramDto> saramList = mybatis.selectList("org.comstudy21.saram.SaramMapper.selectAll");
         
         System.out.println(saramList);
      }
   }

   public static void selectOneTest(String[] args) throws IOException {
      String resource = "mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

      try (SqlSession mybatis = sqlSessionFactory.openSession()) {
         SaramDto saram = mybatis.selectOne("org.comstudy21.saram.SaramMapper.selectSaram", 2);
         
         System.out.println(saram);
      }
   }

}