package day17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ch08Ex04 {
	 // 4번 문제 
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Windows\\system.ini");
		Scanner scan = new Scanner(new FileReader(file));
		
		int lineNumber = 1;
		while(scan.hasNext()) {
			String line = scan.nextLine();
			System.out.println(lineNumber++ + ": " + line);
		}
		scan.close();
	}

}
