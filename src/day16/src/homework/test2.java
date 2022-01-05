package homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// 2번 문제 
public class test2 {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\user\\phone.txt");
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		
		System.out.println("C:\\Users\\user\\phone.txt를 출력합니다.");
		String s = null;
		while((s = br.readLine()) != null) {
			System.out.println(s);
		}

	}

}
