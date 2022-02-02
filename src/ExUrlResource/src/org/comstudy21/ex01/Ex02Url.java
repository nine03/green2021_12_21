package org.comstudy21.ex01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Ex02Url {

	public  Ex02Url() throws IOException {
	      
	      String imgUrlPath = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTExMDdfNjcg%2FMDAxNjM2MjcxNjU1NzAy.wHSi8Wdu8c0SPtKF0KbE9aJ7leph_0AbBqqmz3xrLiIg.2h5ZZXs_jggHgCi7HawudSrldt_gC2AYq-M9fn31WcMg.JPEG.sehm58%2F1636271096527.jpg&type=sc960_832";
	      URL url = new URL(imgUrlPath); // 예외 던져주기
	      
	      InputStream is = url.openStream(); // 인풋스트림 반환 가능
	      DataInputStream dis = new DataInputStream(is);
	      
	      File dir = new File("./images");
	      if(!dir.exists()) { // 없을 시 생성하라!
	         if(dir.mkdir()) { // 폴더 생성은 mkdir
	            System.out.println("새 디렉토리 생성 완료!");
	         }
	      }
	      
	      String saveFilePath = "photo.jpg";
	      File file = new File(dir, saveFilePath);
	      FileOutputStream fos = new FileOutputStream(file);
	      DataOutputStream dos = new DataOutputStream(fos);
	      int data = 0;
	      while((data = dis.read()) != -1) {
	         // 읽어 온 것을 파일로 저장하기
	         dos.write(data);
	         
	      }
	      
	      if(dis != null) dis.close();
	      if(is != null) is.close();
	      if(dos != null) dos.close();
	      if(fos != null) fos.close();
	      
	   
	   }
	   
	   public static void main(String[] args) throws IOException {
	      new Ex02Url();
	   }
	   

	}