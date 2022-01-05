package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
// 3번 문제
public class test3 {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\user\\system1.ini");
		FileReader fr = null;
		
		try {
			System.out.println("C:\\Users\\user\\system1.ini를 출력합니다.");
		fr = new FileReader(file);
		int c;
		while((c = fr.read()) != -1) {
			char a = (char)c;
			a = Character.toUpperCase(a);
			System.out.print(a);
		}
		fr.close();
		} catch(IOException e) {
			System.out.println("입출력 오류");
		}
		
	} 

}
