package day20.Ex06_1;

import java.util.Vector;
import static day20.Ex06_1.R.*;

public class SaramDao {
	private static Vector<SaramDto> saramList = new Vector<SaramDto>();
	
	static {
		saramList.add(new SaramDto(1,"kim","kim@aa.com","010-1111-1111"));
		saramList.add(new SaramDto(2,"lee","lee@aa.com","010-2222-2222"));
		saramList.add(new SaramDto(3,"park","park@aa.com","010-3333-3333"));
	}
	public static int sequence = 4;  
	
	
	public Vector selectAll() {
		Vector vector = new Vector();
		for(int i = 0; i< saramList.size(); i++) {
			vector.add(saramList.get(i).toVector());  
		}
		return vector;
	}
	
	public Vector selectOne() {
		String name = txtFld2.getText();
		Vector vector = new Vector();
		for (int i = 0; i < saramList.size(); i++) {
			if (name.equals(saramList.get(i).getName())) {
				vector.add(saramList.get(i).toVector());
			}
		}
		return vector;
	}
	
	public void insert(SaramDto saramDto) {
		if(saramDto != null) {  
			saramDto.setIdx(sequence++); 
			saramList.add(saramDto);  
		}
	}
	
	public void update(SaramDto dto) {
		for (int i = 0; i < saramList.size(); i++) {
			if (dto.getIdx() == saramList.get(i).getIdx()) {
				saramList.get(i).setName(dto.getName());
				saramList.get(i).setEmail(dto.getEmail());
				saramList.get(i).setPhone(dto.getPhone());
				
			}
		}
	}
	
	public void delete(SaramDto dto) {
		for (int i = 0; i < saramList.size(); i++) {
			if (dto.getIdx() == saramList.get(i).getIdx()) {
				saramList.remove(i);
			}
		}
	}
}
