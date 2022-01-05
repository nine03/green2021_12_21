package Ch08io.json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;

public class TestJsonObj2Read {
	public TestJsonObj2Read() throws FileNotFoundException {
		 InputStream is = this.getClass().getResourceAsStream("members.json"); // RealPath 실행 
		//InputStream is = new FileInputStream("C://members.json");
		//FileInputStream is = new FileInputStream("members.json");
		JSONTokener tk = new JSONTokener(is);
		JSONObject jObj = new JSONObject(tk);
		
		System.out.println(jObj.toString(2));
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		new TestJsonObj2Read();
	}
}
