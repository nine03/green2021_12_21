package org.comstudy21.member.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class MemberDAO {
	// 저장하도록 리스트 만들기 Dao를 저장  벡터라 에레이리스트 
	private static final Vector<MemberDTO> memList = new Vector<MemberDTO>(); // 변경할 수 없다. 
	private static int sequence = 1;  // sequence 같으면 안된다.
	
	static { // static 초기화
		memList.add(new MemberDTO(sequence++,"홍길동","hong@a.com","010-1111-1111"));
		memList.add(new MemberDTO(sequence++,"이순신","lee@a.com","010-2222-2222"));
		memList.add(new MemberDTO(sequence++,"일지매","il@a.com","010-3333-3333"));
		memList.add(new MemberDTO(sequence++,"이순신","lee2@a.com","010-3333-3434"));
	}
	
	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		for(MemberDTO mem : memList) {
			list.add((MemberDTO)mem.clone()); // 형 변환 
		}
		return list;
	}
	
	public MemberDTO selectOne(MemberDTO dto) { // 한개만 찾는거 
		MemberDTO member = null;
		int i = memList.indexOf(dto);
		if(i != -1) {
			member = memList.get(i);
		}
		return member;
	}
	
	public List<MemberDTO> selectByName(String name) { // 이름으로 검색 
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		for(int i=0; i< memList.size(); i++) {
			MemberDTO mem = memList.get(i);
			if(name.equals(mem.getName())) {
				list.add((MemberDTO)mem.clone()); // 캐스팅해야한다.
			}
		}
		return list;
	}
	
	// 삭제
	public boolean delete(MemberDTO dto) { // idx값을 넣고 
		return memList.remove(dto);
	}
	
	// 수정 
	public MemberDTO update(MemberDTO dto) {
		int i = memList.indexOf(dto);
		if(i != -1) {
			return memList.set(i, dto);
		} else {
			return null;
		}
	}
	
	// 저장 로드 
	
	// 로드 
	public List<MemberDTO> fileLoad() {
		return null; 
	}
	
	// 저장
	public boolean fileSave(List<MemberDTO> list) {
		return false;
	}

	public void insert(MemberDTO memberDTO) {
		memberDTO.setIdx(sequence++);
		memList.add(memberDTO);
		
	}
}
