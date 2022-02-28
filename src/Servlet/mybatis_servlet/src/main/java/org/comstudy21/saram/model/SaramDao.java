package org.comstudy21.saram.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SaramDao {
   private String resource;
   private InputStream inputStream;
   private SqlSessionFactory sqlSessionFactory;
   private SqlSession mybatis;
   private String ns = "org.comstudy21.saram.SaramMapper";

   public SaramDao(){
      try {
         resource = "mybatis-config.xml";
         inputStream = Resources.getResourceAsStream(resource);
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
         mybatis = sqlSessionFactory.openSession(true);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public List<SaramDto> selectAll() throws IOException {
      List<SaramDto> saramList = mybatis.selectList(ns + ".selectAll");
      return saramList;
   }

   public SaramDto selectOne(int no) throws IOException {
      SaramDto saram = mybatis.selectOne(ns + ".selectSaram", 2);
      return saram;
   }

   public void insert(SaramDto dto) {
      mybatis.selectOne(ns + ".insertSaram", dto);
   }

   public void update(SaramDto dto) {
      mybatis.selectOne(ns + ".updateSaram", dto);
   }

   public void delete(SaramDto dto) {
      mybatis.selectOne(ns + ".deleteSaram", dto);
   }

}