package homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
// 7번 문제
public class test7 {

		public static void main(String[] args) {
			BufferedInputStream srcStream = null;
			BufferedOutputStream destStream = null;
			File srcFile = new File("a.jpg");
			File destFile = new File("b.jpg");
			try {
				srcStream = new BufferedInputStream(new FileInputStream(srcFile));
				destStream = new BufferedOutputStream(new FileOutputStream(destFile)); 

				long tenPercent = srcFile.length() / 10; 
				long progress = 0; 

				System.out.println("a.jpg를 b.jpg로 복사합니다. \n10%마다 *를 출력합니다.");
				byte[] buf = new byte[1024]; 
				int numRead = 0; 
				while (true) {
					numRead = srcStream.read(buf, 0, buf.length);
					if (numRead == -1) { 
						if (progress > 0) { 
							System.out.print("*");
						}
						break;
					}
					if (numRead > 0)
						destStream.write(buf, 0, numRead);

					progress += numRead; 
					if (progress >= tenPercent) { 
						System.out.print("*");
						progress = 0; 
					}
				}
				srcStream.close();
				destStream.close();
			} catch (IOException e) {
				System.out.println("입출력 오류가 발생했습니다.");
			}
		}
}
