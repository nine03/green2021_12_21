package org.comstudy21.member.test;

import java.util.List;

import org.comstudy21.member.model.MemberDTO;
import org.comstudy21.member.resource.R;

public class TestAppMain extends R {
	
	public TestAppMain() {
		//viewTest();
		//daoInsertTest();
		//daoDeleteTest();
		//daoUpdateTest();
		//daoSelectTest();
		// daoSelectOneTest();
		daoSelectByNameTest();
	}

	 private void daoSelectByNameTest() {
	      List<MemberDTO> list = memDao.selectByName("이순신");
	      System.out.println(list);
	   }

	   private void daoSelectOneTest() {
	      MemberDTO member = memDao.selectOne(new MemberDTO(2, null, null, null));
	      System.out.println(member);
	   }


	private void daoUpdateTest() {
		memDao.update(new MemberDTO(2,"강감찬","kang@kang.com","010-9999-9999"));
		
	}

	private void daoDeleteTest() {
		
		memDao.delete(new MemberDTO(2,null,null,null));
		
	}

	private void daoInsertTest() {
		memDao.insert(new MemberDTO(0, "마이콜", "ma@aa.com", "010-1234-1234")); // 한번만 하고 끝난다.
	}

	private void daoSelectTest() {
		List<MemberDTO> list = memDao.selectAll();
		for(MemberDTO mem : list) {  // for 맵으로 하면 칸을 맞출수있다 
			System.out.println(mem);
		}
	}

	private void viewTest() {
		mainActivity.setContentView(input);
		
	}

	public static void main(String[] args) {
		new TestAppMain();
	}
}
