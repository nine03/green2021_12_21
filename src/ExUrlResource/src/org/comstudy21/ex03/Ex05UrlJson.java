package org.comstudy21.ex03;

import java.awt.Container;
import java.awt.GridLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

// 오늘의 명언 : 작은것부터 차근차근
public class Ex05UrlJson extends JFrame {
	// 전역변수
   public static final int SIZE = 12;
   public static final ArrayList<String> thumbnailUrlList = new ArrayList<String>();
   public static final ArrayList<String> thumbnailNameList = new ArrayList<String>();
   public static final ArrayList<ImageIcon> imgIcoList = new ArrayList<ImageIcon>();
   public static final ArrayList<JLabel> lblList = new ArrayList<JLabel>();
   
   public JPanel centerPane = new JPanel(new GridLayout(3,4));
   public Container contentPane;
   public JLabel statusLbl = new JLabel("Status : 준비중입니다.");
   public Ex05UrlJson() throws IOException {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(800, 600);
      // 1. 미리 12개의 JLabel과 ImageIcon을 centerPane에 준비한다.
      // 2. 이미지가 로드되는 순서대로 보여지게 한다.
      contentPane = this.getContentPane();
      contentPane.add(new JScrollPane(centerPane));
      for(int i=0; i<SIZE; i++) {
         lblList.add(new JLabel());
         centerPane.add(lblList.get(i));
      }
      
      setVisible(true);
      
      // 이미지 불러오기 
      init();
      
   }

   public void init() throws IOException {
      URL jsonUrl = new URL("https://jsonplaceholder.typicode.com/photos");

      JSONTokener jsonTk = new JSONTokener(jsonUrl.openStream());
      JSONArray jsonArr = new JSONArray(jsonTk);
      // System.out.println("json arr size : " + jsonArr.length());
      for (int i = 0; i < SIZE; i++) {
         JSONObject jsonObj = jsonArr.getJSONObject(i);
         // System.out.println(i + ". thumbnailUrl : " + jsonObj.get("thumbnailUrl"));
         String thumbUrl = (String) jsonObj.get("thumbnailUrl");
         String thumbName = (String) thumbUrl.substring(thumbUrl.lastIndexOf("/") + 1);
         thumbnailUrlList.add(thumbUrl);
         thumbnailNameList.add(thumbName);
         
         // for문이 1회전 할때 마다 이미지 하나가 저장 됨.
         String thumbDir = "./photo";
         File thumbFile = new File(thumbDir, thumbName);
         if(!thumbFile.exists()) {
            saveImage(thumbName, thumbUrl, thumbDir);
         }
         //imgIcoList.get(i).setImage(new ImageIcon(thumbFile.getPath()).getImage());
         ImageIcon ico = new ImageIcon(thumbFile.getPath());
         lblList.get(i).setIcon(ico);
         imgIcoList.add(ico);
      }
   }

   private void saveImage(String imgName, String imgUrlPath, String dirPath) throws IOException {
      URL url = new URL(imgUrlPath);

      InputStream is = url.openStream();
      DataInputStream dis = new DataInputStream(is);

      File dir = new File(dirPath);
      if (!dir.exists()) {
         if (dir.mkdir()) {
            System.out.println("새 디렉토리 생성 완료!");
         }
      }
      File file = new File(dir, imgName);
      FileOutputStream fos = new FileOutputStream(file);
      DataOutputStream dos = new DataOutputStream(fos);
      int data = 0;
      while ((data = dis.read()) != -1) {
         // 파일로 저장 하기
         dos.write(data);
      }

      if (dis != null)
         dis.close();
      if (is != null)
         is.close();
      if (dos != null)
         dos.close();
      if (fos != null)
         fos.close();
   }

   public static void main(String[] args) throws Exception {
      new Ex05UrlJson();
   }

}