package miniproj.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AddressbookDAO {
	public static int no = 1;
	private static File file = new File("Addressbook.dat");
	private static FileInputStream fis;
	private static ObjectInputStream ois;
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;
	private static ArrayList<AddressbookVo> pList;

	{
		if (file.exists()) {
			pImport();
			if (pList.size() != 0) {
				no = pList.get(pList.size() - 1).getNo() + 1;
			}
		}else {
			pList = new ArrayList<AddressbookVo>();
		}

	}

	// 입력
	public boolean input(AddressbookVo vo) {
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getName().equals(vo.getName())) {
				return false;
			}
		}
		vo.setNo(no++);
		return pList.add(vo);
	}

	// 삭제
	public void delete(AddressbookVo vo) {
		int idx;
		if (vo != null) {
			idx = pList.indexOf(vo);
			pList.remove(idx);
		}

	}

	// 검색
	public AddressbookVo search(AddressbookVo vo) {
		if (vo == null || pList.size()==0) {
			return null;
		}
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getName().equals(vo.getName())) {
				AddressbookVo p = new AddressbookVo();
				p.setNo(pList.get(i).getNo());
				p.setName(pList.get(i).getName());
				p.setTel(pList.get(i).getTel());
				p.setEmail(pList.get(i).getEmail());
				return p;
			}
		}
		return null;
	}

	// 출력
	public ArrayList<AddressbookVo> print() {
		ArrayList<AddressbookVo> list = new ArrayList<>();
		if (pList.size()==0) {
			return null;
		}
		for (int i = 0; i < pList.size(); i++) {
			AddressbookVo p = new AddressbookVo();
			p.setNo(pList.get(i).getNo());
			p.setName(pList.get(i).getName());
			p.setTel(pList.get(i).getTel());
			p.setEmail(pList.get(i).getEmail());

			list.add(p);
		}
		return list;
	}

	// 수정
	public void update(AddressbookVo vo) {
		if (vo == null || pList.size()==0) {
			return;
		}
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getNo() == vo.getNo()) {
				pList.set(i, vo);
			}
		}
	}

	// 저장
	public void save() {
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(pList);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
			}
		}
	}

	// 저장된 파일 읽어오기
	public void pImport() {
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			pList = (ArrayList<AddressbookVo>) ois.readObject();
		} catch (FileNotFoundException e) {
			pList = new ArrayList<AddressbookVo>();
		} catch (ClassNotFoundException e) {
		} catch (IOException e) {
			return;
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
			}
		}
	}

}
