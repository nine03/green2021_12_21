package Ch08io_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjStreamTest {
	
	// 객체 직렬화
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// ObjectInputStream 입력 , ObjectOutputStream 기록 
		File file = new File("C:\\Users\\user\\saram.dat");
		FileOutputStream fos = new FileOutputStream(file);
		FileInputStream fis = new FileInputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Saram data1 = new Saram(1, "홍길동", "hong@h.com");
		Saram data2 = new Saram(2, "김길동", "kim@h.com");
		Saram data3 = new Saram(3, "박길동", "park@h.com");
		ArrayList<Saram> list = new ArrayList<Saram>();
		list.add(data1);
		list.add(data2);
		list.add(data3);
		
		oos.writeObject(list);
		System.out.println("객체 저장 완료!");
		
		ArrayList<Saram> list2 = (ArrayList<Saram>) ois.readObject(); // 형변환 시켜줘야한다
		System.out.println(list2);
	}

}
