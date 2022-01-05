package homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

// 1번 문제 
public class test1 {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\user\\phone.txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		Scanner scan = new Scanner(System.in);
		InputStream is = System.in;
		System.out.println("전화번호 입력 프로그램입니다.");
		String data = null;
		try {
			while (true) { 
				System.out.println("이름 전화번호 >> ");
				String line = scan.nextLine();
				
				if(line.equals("그만")) {
					System.out.println("C:\\Users\\user\\phone.txt에 저장하였습니다.");
					break;
				}
				bw.write(line);
				bw.write("\r\n");
			}
		} catch (NoSuchElementException e) {
			System.out.println("입출력 오류");
		}finally {
			bw.close(); // 이거 안닫아주면 계속 열려있기때문에 기록이안된다.
		}
	}
}
