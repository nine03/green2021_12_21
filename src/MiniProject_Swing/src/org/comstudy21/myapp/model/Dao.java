package org.comstudy21.myapp.model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Dao {
	static ArrayList<Dto> list = new ArrayList<>();
	//파일 입출력 준비
	static FileReader reader;
	static FileWriter writer;
	// 데이터 파일의 경로
	static String pathname = "src/org/comstudy21/myapp/resource/data.json";
	
	public static void loadDataList() {
		File dataFile = new File(pathname);
		try {
			if(!dataFile.exists()) {
			
				// data.json 파일이 없으면 파일을 새로 생성하고 기본 데이터를 저장한다.
				if(dataFile.createNewFile()) {
					//System.out.println(">>> 파일이 생성 되었습니다!");
					// JSONObject 생성 -> JSONArray 생성 -> JSONObject -> 저장
					JSONObject obj = new JSONObject();
					obj.put("no", 1);
					obj.put("name", "test");
					obj.put("email", "test@test.com");
					obj.put("phone", "010-0000-0000");
					JSONArray array = new JSONArray();
					array.put(obj);
					JSONObject root = new JSONObject();
					root.put("member", array);
					root.put("seq", 2);
					
					// 파일쓰기 준비
					writer = new FileWriter(dataFile);
					writer.write(root.toString(2));
					//writer.close();
				}
			
			} 
			//System.out.println("파일이 존재 합니다!");
			// 파일의 내용을 읽어오기 -> list에 담아주기
			reader = new FileReader(dataFile);
			// reader를 이용해서 JSONTokener 객체 만들기
			JSONTokener tokener = new JSONTokener(reader);
			// JSONTokener를 JSONObject로 바꾸기
			JSONObject root = new JSONObject(tokener);
			// JSONArray를 뽑아 온다.
			JSONArray array = root.getJSONArray("member");
			// array의 요소를 DTO로 바꿔서 list에 저장
			list.clear();
			for(int i=0; i<array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);
				Dto dto = new Dto();
				dto.setNo(obj.getInt("no")+"");
				dto.setName(obj.getString("name"));
				dto.setEmail(obj.getString("email"));
				dto.setPhone(obj.getString("phone"));
				list.add(dto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(reader != null) reader.close();
				if(writer != null) writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void saveDataList() {
		// 리스트의 내용이 없다면 그냥 종료
		if(list.size() == 0) {
			JOptionPane.showMessageDialog(null, "저장 할 내용이 없습니다!");
			return;
		}
		
		File dataFile = new File(pathname);
		if(!dataFile.exists()) {
			JOptionPane.showMessageDialog(null, "저장 파일이 존재 하지 않습니다!");
			return;
		}
		//System.out.println(">>> 파일이 생성 되었습니다!");
		// JSONObject 생성 -> JSONArray 생성 -> JSONObject -> 저장
		JSONArray array = new JSONArray();
		int max = 0;
		for(int i=0; i<list.size(); i++) {
			Dto dto = list.get(i);
			JSONObject obj = new JSONObject();
			int no = 0;
			try {
				no = Integer.parseInt(dto.getNo()==null?"0":dto.getNo());
			} catch (NumberFormatException e) {
				
			}
			if(no > max) {
				max = no;
			}
			obj.put("no", no);
			obj.put("name", dto.getName());
			obj.put("email", dto.getEmail());
			obj.put("phone", dto.getPhone());
			array.put(obj);
		}
		JSONObject root = new JSONObject();
		root.put("member", array);
		root.put("seq", max+1);
		
		try {
			// 파일쓰기 준비
			writer = new FileWriter(dataFile);
			writer.write(root.toString(2));
			//writer.close();
			System.out.println("저장 완료");
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 중요: 저장 후에 파일 스트림을 close() 하지 않으면 쓰기가 완료 되지 않는다.
			try {
				if(reader != null) reader.close();
				if(writer != null) writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList<Dto> selectAll() {
		// 나중에 파일에 있는 데이터를 가져와서 리스트를 만든다.
		//list.add(new Dto("1","kim","kim@k.com","010-1111-1111"));
		//list.add(new Dto("2","lee","lee@k.com","010-1111-1111"));
		//list.add(new Dto("3","park","park@k.com","010-1111-1111"));
		
		// json 파일에 저장된 데이터 불러오기
		//loadDataList();
		
		return list;
	}

	public static void insert(Dto dto) {
		list.add(dto);
		
		// 리스트의 내용을 json 파일에 저장하는 기능.
		saveDataList();
	}

	public static Dto findMember(Dto dto) {
		int index = list.indexOf(dto);
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "찾는 멤버가 없습니다!");
			return null;
		}
		return list.get(index);
	}

	public static void delete(Dto dto) {
		int index = list.indexOf(dto);
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "삭제 할 대상을 찾을 수 없습니다!");
			return;
		}
		
		list.remove(index);
		saveDataList(); 
	}
	
//	static {
//	// 나중에 파일에 있는 데이터를 가져와서 리스트를 만든다.
//	list.add(new Dto("1","kim","kim@k.com","010-1111-1111"));
//	list.add(new Dto("2","lee","lee@k.com","010-1111-1111"));
//	list.add(new Dto("3","park","park@k.com","010-1111-1111"));
//}
}
