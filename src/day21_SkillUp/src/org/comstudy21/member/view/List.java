package org.comstudy21.member.view;

import org.comstudy21.member.model.MemberDTO;

public class List extends MemberView {

	@Override
	public boolean onCreate() {
		System.out.println(titleList);
		
		// 요청할때 관리하는 객체 
		// request에서 List를 가져오기
		java.util.List<MemberDTO> memlist = (java.util.List<MemberDTO>)request.get("memList");
		for(MemberDTO member : memlist) {
			System.out.println(member);
		}
		
		return false;
	}

}
