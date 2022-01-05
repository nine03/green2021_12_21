package homework;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
// 4번 문제
public class test4 {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\user\\system2.ini");
		FileReader fr = null;
		
		try {
			fr = new FileReader(file);
			Scanner scan = new Scanner(file);
			System.out.println("C:\\Users\\user\\system2.ini파일을 읽어 출력합니다.");
			int i = 0;
			while(scan.hasNext()) {
				i++;
				String line = scan.nextLine();
				System.out.printf("%4d" + ": ",i);
				System.out.println(line);
			}
		} catch (Exception e) {
			System.out.println("입출력 오류");
		}
	}
}
