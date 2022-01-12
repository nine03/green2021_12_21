package day20.Ex06;

import java.util.Vector;

public class SaramDao {
	private static Vector<SaramDto> saramList = new Vector<SaramDto>();
	static { // static 초기화
		saramList.add(new SaramDto(1,"kim","kim@aa.com","010-1111-1111"));
		saramList.add(new SaramDto(2,"lee","lee@aa.com","010-2222-2222"));
		saramList.add(new SaramDto(3,"park","park@aa.com","010-3333-3333"));
	}
	public static int sequence = 4;  // 입력할때 sequence를 넣어준다 그러면 입력하면 4로 들어간다.
	
	
	public Vector selectAll() {
		Vector vector = new Vector();
		for(int i = 0; i< saramList.size(); i++) {
			vector.add(saramList.get(i).toVector()); // toVector 데이터를 Vector로 만들어서 넘겨준다  
		}
		return vector;
	}

	public void insert(SaramDto saramDto) {
		if(saramDto != null) {  
			saramDto.setIdx(sequence++); // idx값이 없다 
			saramList.add(saramDto); // 함수에 넣어준다 
		}
	}
}

// 코틀린에서 null 체크하기 쉽다.