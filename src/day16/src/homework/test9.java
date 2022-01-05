package homework;

import java.io.File;
// 9번 문제
public class test9 {

	public static void main(String[] args) {
		File dir = new File("C:\\Users\\user\\us");
		File [] files = dir.listFiles(); 
		
		System.out.println(dir.getPath() + "디렉터리의 .txt 파일을 모두 삭제합니다....");
		int count = 0;
		for(int i=0; i<files.length; i++) {
			if(!files[i].isFile())
				continue;
			
			String name = files[i].getName();
			int index = name.lastIndexOf('.'); 
			if(index == -1) 
				continue;
			
			String ext = name.substring(index);  
			if(ext.equals(".txt")) {
				System.out.println(files[i].getPath() + " 삭제");
				files[i].delete();
				count++;
			}
		}
		System.out.println("총 "+ count + "개의 .txt 파일을 삭제하였습니다.");
	}

}