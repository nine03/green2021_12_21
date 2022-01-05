package homework_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class PhoneBook {
	private static File file = new File("C:\\Users\\user\\us\\phonebook.txt");
	private static FileInputStream fis;
	private static ObjectInputStream ois;
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;
	
	public PhoneBook() throws ClassNotFoundException, IOException {
		run();
	}
	
	public static final int INPUT = 1;
	public static final int PRINT = 2;
	public static final int SEARCH = 3;
	public static final int DELETE = 4;
	public static final int SAVE = 5;
	public static final int INPORT = 6;
	public static final int EXIT = 7;
	
	private static int no = 0;
	private static ArrayList<Phone> pList = new ArrayList<>(); 
	
	public static String getLine() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static int getNum() {
		String s = getLine();
		StringBuffer s2 = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= '0' && ch <= '9' || ch == '-') {
				s2.append(ch);
			}
		}
		return Integer.parseInt(s2.toString());
	}
	
	public void run() throws ClassNotFoundException, IOException {
		System.out.print("1.입력 2.출력 3.검색 4.삭제 5.저장 6.가져오기 7.종료 >> ");
		no = getNum();
		
		switch(no) {
		case INPUT: input(); break;
		case PRINT: print(); break;
		case SEARCH: search(); break;
		case DELETE: delete(); break;
		case SAVE: save(); break;
		case INPORT : pImport(); break;
		case EXIT: 	save();
			System.out.println("저장 후 프로그램 종료");
			System.exit(0);
			break;
		default : System.out.println("해당 사항 없습니다! 다시입력해 주세요!"); run();
		}
		run();
	}

	// 입력
	public void input() {
		System.out.println("-------------------- Input --------------------");
		System.out.println("이름, 전화번호, 이메일을 입력해 주세요!");
		System.out.print("이름 >> ");
		String name = getLine();
		System.out.print("전화번호 >> ");
		String tel = getLine();
		System.out.print("이메일 >> ");
		String email = getLine();
		
		pList.add(new Phone(name, tel, email));
	}

	// 삭제
	public void delete() {
		System.out.println("-------------------- Delete --------------------");
		System.out.print("삭제할 사람의 이름을 입력해 주세요! >> ");
		String name = getLine();
		
		int idx;	
		if((idx = pList.indexOf(new Phone(name,"",""))) != -1) {
			System.out.println(pList.get(idx));			
		}else {
			System.out.println(name+"은 없습니다!");
		}
		char ch;
		System.out.print("삭제하시겠습니까? (y or n) >> ");
		ch = getLine().charAt(0);
		if(ch=='y'||ch=='Y') {
			System.out.println(name+"의 정보가 삭제되었습니다.");
			pList.remove(idx);
		}
	}
	// 검색
	public void search() {
		System.out.println("-------------------- Search --------------------");
		System.out.print("검색할 사람의 이름을 입력해 주세요!");
		String name = getLine();
		int idx;
		if((idx = pList.indexOf(new Phone(name,"",""))) != -1) {
			System.out.println(name+"의 정보입니다.");
			System.out.println(pList.get(idx));			
		}else {
			System.out.println(name+"은 없습니다!");
		}
		
	}
		
	// 출력
	public void print() throws ClassNotFoundException, IOException {
		System.out.println("-------------------- Print --------------------");
		System.out.print("1.현재 리스트 2.저장된 리스트 >> ");
		int num = getNum();
		
		switch(num) {
		case 1 : print01(); break;
		case 2 : print02(); break;
		default : System.out.println("해당사항 없습니다. 다시입력하세요!"); print();
		}
	}

	public void print01() {
		System.out.println("현재 리스트 정보입니다.");
		if(pList.size() == 0) {
			System.out.println("리스트가 비었습니다!");
			return;
		}
		Iterator<Phone> it = pList.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public void print02() throws IOException, ClassNotFoundException {
		fis = new FileInputStream(file);
		ois = new ObjectInputStream(fis);
		ArrayList<Phone> list = (ArrayList<Phone>) ois.readObject();
		
		System.out.println("저장된 파일의 리스트입니다.");
		Iterator<Phone> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		ois.close();
	}
	// 저장
	public void save() throws IOException {
		System.out.println("-------------------- Save --------------------");
		fos = new FileOutputStream(file);
		oos = new ObjectOutputStream(fos);
		ArrayList<Phone> list = pList;
		oos.writeObject(list);
		System.out.println("저장 완료");
		
		oos.close();
	}
	
	private void pImport() throws IOException, ClassNotFoundException {
		System.out.println("-------------------- Import --------------------");
		fis = new FileInputStream(file);
		ois = new ObjectInputStream(fis);
		pList = (ArrayList<Phone>) ois.readObject();
		System.out.println("가져오기를 완료했습니다!");
		print02();
		
		ois.close();
	}

}
