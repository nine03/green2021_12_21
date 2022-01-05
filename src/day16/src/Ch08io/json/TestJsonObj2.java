package Ch08io.json;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestJsonObj2 {
	public static void main(String[] args) throws IOException {
		JSONObject jsonObj = new JSONObject(); // map 이랑 비슷하다
		jsonObj.put("no", "1");
		jsonObj.put("name", "hong");
		jsonObj.put("email", "hong@h.com");
		
		JSONObject jsonObj2 = new JSONObject(); // map 이랑 비슷하다
		jsonObj2.put("no", "2");
		jsonObj2.put("name", "kim");
		jsonObj2.put("email", "kim@h.com");

		JSONObject jsonObj3 = new JSONObject(); // map 이랑 비슷하다
		jsonObj3.put("no", "3");
		jsonObj3.put("name", "park");
		jsonObj3.put("email", "park@h.com");
		
		JSONArray jArr = new JSONArray();
		jArr.put(jsonObj);
		jArr.put(jsonObj2);
		jArr.put(jsonObj3);
		
		//System.out.println(jsonObj.toString(1)); //1 넣으면 보기 쉽게 만들어준다 
		// 만들어진 JSONObject 데이터 파일에 기록하기 
		JSONObject rootObj = new JSONObject();
		rootObj.put("members", jArr);
		
		// 파일에 기록
		// RealPath에 저장 
		FileWriter writer = new FileWriter("src\\Ch08io\\json\\members.json");
		writer.write(rootObj.toString(2));
		writer.close();
	}
}
