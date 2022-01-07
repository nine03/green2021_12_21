package miniproj1.view;

import miniproj1.R;

public class EditView extends View {
	@Override
	public void display() {
		System.out.println("-------------------    수정    -------------------");
		if(R.AddressbookVo == null) {
			System.out.println("정보가 없습니다.");
			return;
		}
		while(true) {
			try {
				print();
				System.out.println(R.AddressbookVo);
				System.out.println("-------------------------------------------------");
				System.out.println("무엇을 수정하시겠습니까?");
				System.out.println("1.이름 2.전화번호 3.이메일 4.종료");
				System.out.print("선택 >>");
				choice = sc.nextInt();
			} catch (Exception e) {
				sc.next();
				System.out.println("정수만 입력하시오.");
				continue;
			}
			switch(choice) {
			case 1:
				System.out.print("새로운 이름 입력 >>");
				String name = sc.next();
				R.AddressbookVo.setName(name);
				break;
			case 2:
				System.out.print("새로운 전화번호 입력 >>");
				String phoneNum = sc.next();
				R.AddressbookVo.setPhoneNum(phoneNum);
				break;
			case 3:
				System.out.print("새로운 이메일 입력 >>");
				String email = sc.next();
				R.AddressbookVo.setEmail(email);
				break;
			case 4:
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		
		}
	}
}
