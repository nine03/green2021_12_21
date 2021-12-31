package day13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Ch06Ex01 {
	public static void main(String[] args) {
		String queryStr = "user=hong&msg=hello&job=killer";
		StringTokenizer st = new StringTokenizer(queryStr,"&");
		HashMap<String, String> messageMap = new HashMap<String, String>();
		
		while(st.hasMoreTokens()) {
			String tk = st.nextToken();
			String[] keyValue = tk.split("=");
			//System.out.println(Arrays.toString(keyValue));  // key , value
			messageMap.put(keyValue[0], keyValue[1]); // put으로 값 저장하고  
		}
//		System.out.println(messageMap.get("user")); // get으로 값을 가져온다
//		System.out.println(messageMap.get("msg"));
//		System.out.println(messageMap.get("job"));
		
		Iterator<String> it = messageMap.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.printf("%s => %s\n",key,messageMap.get(key));
		}
	}
}
