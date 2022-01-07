package homework;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import homework.Info;

public class Util {
	public static List<Info> readFile(File file) throws IOException {
        FileReader filereader = null;
        List<Info> InfoList = new ArrayList<Info>();
 
        try {
            filereader = new FileReader(file);
            InfoList = readReader(filereader); // 파일에서 읽어온 정보를 List에 저장
        } finally {
            if (filereader != null)
                filereader.close();
        }
        return InfoList;
    }
	
	  public static void writeFile(String dir, String name, List<Info> InfoList ) throws IOException {
	        OutputStream out = null;
	        try {
	            File dirent = new File(dir);
	            
	            
	            if(!dirent.exists()) { // 저장할 디렉토리 존재하지 않으면 생성
	                dirent.mkdir();
	            }
	 
	            File outFile = new File(dir, name);
	 
	            
	            if(outFile.exists()) { // 파일 존재하면 삭제 
	                outFile.delete();
	            }
	            
	            
	            out = new BufferedOutputStream(new FileOutputStream(outFile));  // 파일에 String값을 입력할때 BufferedOutputStream 생성
	            for(int idx=0; idx < InfoList.size(); idx++) {
	                
	            	// List에서 개인정보를 가져오기
	                String writeStr = InfoList.get(idx).getPN() + "," + InfoList.get(idx).getName() + "," + InfoList.get(idx).getAge() + ","
	                                + InfoList.get(idx).getSex() + ","+ InfoList.get(idx).getNumber() + "," + InfoList.get(idx).getPhonenumber()+"\n";
	 
	                
	                byte[] b = writeStr.getBytes();  // 저장한 string값을 Byte 배열로 변경
	                
	                
	                out.write(b);  // 파일에 내용 쓰기 
	            }
	        } catch (IOException ioe) {
	            
	            ioe.printStackTrace(); // 입출력할때 예외발생하면 내용 출력
	            throw ioe;
	        } finally {
	            try {
	                if (out != null) 
	                	out.close(); // 객체를 close 
	            } catch (Exception e) {
	            }
	        }
	    } 
	  public static List<Info> readReader(Reader input) throws IOException {
	        try {
	            
	            BufferedReader in = new BufferedReader(input); // 객체 생성 
	            String line;
	            
	            List<Info> InfoList = new ArrayList<Info>();
	 
	            
	            while((line=in.readLine()) != null) { // 파일 한줄씩읽기
	                
	                String[] writeStr = line.split(","); // ","로 split하여 배열에 저장
	                
	                
	                if(writeStr.length != 6) continue;  // 모든 정보가 저장되어 있지 않다면 skip처리
	                
	                Info personInfo = new Info();
	                
	                // 각 개인정보를 저장
	                personInfo.setPN(Integer.parseInt(writeStr[0]));
	                personInfo.setName(writeStr[1]);
	                personInfo.setAge(Integer.parseInt(writeStr[2]));
	                personInfo.setSex(writeStr[3]);
	                personInfo.setNumber(writeStr[4]);
	                personInfo.setPhonenumber(writeStr[5]);
	                
	                
	                InfoList.add(personInfo);  // 리스트에 객체 추가.
	            }
	            
	            return InfoList;
	        } finally {
	            input.close();
	        }
	    }
	}