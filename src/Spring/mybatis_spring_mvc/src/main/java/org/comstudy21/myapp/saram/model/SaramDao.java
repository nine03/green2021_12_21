package org.comstudy21.myapp.saram.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 실행 시 saramDao 빈으로 자동 생성된다. 
// root - context.xml에 생성 되는 빈과 동일하다.
@Repository
public class SaramDao {
   
	// root - context.xml에 생성한 bean을 사용한다.
   @Autowired
   private SqlSessionTemplate mybatis;
   private String ns = "org.comstudy21.saram.SaramMapper";

   public List<SaramDto> selectAll() {
  
		List<SaramDto> saramList = mybatis.selectList(ns + ".selectAll");
		  return saramList;
   }

   public SaramDto selectOne(int no) {
      SaramDto saram = mybatis.selectOne(ns + ".selectSaram", no);
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