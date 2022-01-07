package miniproj1.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AddressbookDao {
	private static final ArrayList<AddressbookVo> AddressbookArr = new ArrayList<AddressbookVo>();

	static {
		AddressbookArr.add(new AddressbookVo("카리나", "010-2222-3333", "karina@naver.com"));
		AddressbookArr.add(new AddressbookVo("윈터",  "010-3333-4444", "winter@naver.com"));
		AddressbookArr.add(new AddressbookVo("지젤", "010-4444-5555", "giselle@naver.com"));
		AddressbookArr.add(new AddressbookVo("닝닝", "010-5555-6666", "ningning@naver.com"));
	}

	public ArrayList<AddressbookVo> selectAll() {
		ArrayList<AddressbookVo> nArr = new ArrayList<AddressbookVo>();
		for (int i = 0; i < AddressbookArr.size(); i++) {
			nArr.add(AddressbookArr.get(i));
		}
		return nArr;
	}

	public AddressbookVo selectByName(AddressbookVo vo) {
		for (AddressbookVo select : AddressbookArr) {
			if (vo.getName().equals(select.getName())) {
				return select;
			}
		}
		return null;
	}

	public void insert(AddressbookVo vo) {
		AddressbookArr.add(vo);
	}

	public void update(AddressbookVo vo) {
		if(vo == null) {
			return;
		}
		for (int i = 0; i < AddressbookArr.size(); i++) {
			AddressbookVo select = AddressbookArr.get(i);
			if (vo.getName().equals(select.getName())) {
				AddressbookArr.set(i, vo);
				return;
			}
		}		
	}

	public void delete(AddressbookVo vo) {
		for (int i = 0; i < AddressbookArr.size(); i++) {
			AddressbookVo select = AddressbookArr.get(i);
			if (vo.getName().equals(select.getName())) {
				AddressbookArr.remove(i);
				System.out.println("삭제되었습니다.");
				return;
			}
		}
		System.out.println(vo.getName() + "는 존재하지 않습니다.");
	}
	
	File file = null;
	public void save(String name) throws IOException {
		File dir = new File("./save");
		if(!dir.exists()) dir.mkdir();
		file = new File("save\\" + name + ".dat");
		FileOutputStream fis = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fis);
		oos.writeObject(AddressbookArr);
		System.out.println("저장이 완료되었습니다.");
	}
	
	public void load(String name) {
		//System.out.println(">>>> load()");
		try {
			File dir = new File("./save");
			if(!dir.exists()) dir.mkdir();
			file = new File("save\\" + name + ".dat");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<AddressbookVo> nArr = (ArrayList<AddressbookVo>)ois.readObject();
			AddressbookArr.clear();
			for(int i=0; i<nArr.size(); i++) { 
				AddressbookArr.add(i, nArr.get(i));
			}
			System.out.println("로드가 완료되었습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			return;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
