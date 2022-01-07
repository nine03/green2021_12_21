package day17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.DomainCombiner;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ch08Ex01 {
	
	// 1번 2번 문제 
	static Scanner scan = new Scanner(System.in);
	   static File file = new File("C:\\Temp\\phone.txt"); //파일이 먼저 생성 
	   static FileWriter writer = null;
	   static FileReader reader = null;   // 문자한개씩 읽어올수도 있고 문자열 전체로 읽어올수도있고
	   static BufferedReader br = null;
	   
	   public static String readFile(String src) {
		   StringBuffer lines = new StringBuffer();
	      try {
	         // 파일의 내용을 읽어서 출력하기 - FileReader 사용.
	    	  if(src != null) file = new File(src);
	    	  file = new File(src);
	         reader = new FileReader(file);
	         br = new BufferedReader(reader);
	         String data = null;
	        
	         while ((data = br.readLine()) != null) {
	            lines.append(data);
	            lines.append('\n');
	         }
	         //System.out.println(lines.toString());
	      } catch (FileNotFoundException e) {
	         System.out.println("지정한 파일이 없습니다."); //저장
	      } catch (IOException e) {
	         e.printStackTrace();
	      } finally {
	         if (reader != null) { // 한줄씩 읽어오기 
	            try {
	               reader.close();
	            } catch (IOException e) {
	               e.printStackTrace();
	            }
	         }
	      } // try catch end
	      return lines.toString();
	   }

	   public static void writeFile(String[] args) {
	      try {
	         writer = new FileWriter(file);
	         StringBuffer sb = new StringBuffer();
	         System.out.println("전화 번호 입력 프로그램입니다.(그만 입력은 종료)");
	         while (true) {
	            System.out.print("이름 전화번호 >> ");
	            String line = scan.nextLine();
	            if ("그만".equals(line))
	               break;
	            sb.append(line);
	            sb.append('\n');
	         }
	         writer.write(sb.toString());
	         System.out.println(file.getPath() + "에 저장하였습니다.");
	      } catch (FileNotFoundException e) {
	         System.out.println("지정한 파일이 없습니다.");
	      } catch (IOException e) {
	         e.printStackTrace();
	      } finally {
	         if (writer != null) {
	            try {
	               writer.close();
	            } catch (IOException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	   }
	   

	public static void main01(String[] args) { 
		writeFile(null);
	    String data =   readFile(null);
	    System.out.println(data); // 파일을 통제로 다읽어온다
	}
	
	public static void main02(String[] args) { // 3번 문제 
		String data = readFile("C:\\Windows\\system.ini");
		System.out.println(data.toUpperCase());
	}
	
	public static void main(String[] args) {  // 4번 문제 
		String data = readFile("C:\\Windows\\system.ini");
		StringTokenizer stk = new StringTokenizer(data,"\n");
		int cnt = 1;
		while(stk.hasMoreTokens()) {
			System.out.println(cnt++ + ": " + stk.nextToken());
		}
	}
}
