package homework;

import java.util.Scanner;

public class PersonDesk {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        //추가, 삭제, 수정을 위한 객체 생성
        PersonManager pm = new PersonManager();
        
 
        boolean power = true;
        
        while(power) {
            scan.reset();
            System.out.println("1. 출력, 2. 추가, 3. 수정, 4. 삭제, 5. 종료, 6. 처음으로");
            
            String menuNum = scan.next();
 
            if("1".equals(menuNum)) {
                pm.showInfo();
            }else if("2".equals(menuNum)) {
                pm.addInfo(makeInfo());
            }else if("3".equals(menuNum)) {
                System.out.println("수정할 정보의 고유번호를 입력해 주세요.");
                int PN = scan.nextInt();
                pm.updateInfo(makeInfo(), PN);
            }else if("4".equals(menuNum)) {
                System.out.println("삭제할 정보의 고유번호를 입력해 주세요.");
                pm.removeInfo(scan.nextInt());
            }else if("5".equals(menuNum)) {
                power = false;
            }else if("6".equals(menuNum)) {
                continue;
            }else {
                System.out.println("해당 메뉴는 없는 메뉴입니다. 다시 선택 바랍니다.");
                continue;    
            }
        }
        scan.close();
    }
    
    public static PersonInfo makeInfo() {
        scan.reset();
        PersonInfo person = new PersonInfo();
        
        System.out.print("이름 : ");
        person.setName(scan.next());
        
        System.out.println();
 
        System.out.print("나이 : ");
        person.setAge(scan.nextInt());
 
        System.out.println();
 
        System.out.print("성별  : ");
        person.setSex(scan.next());
 
        System.out.println();
 
        System.out.print("전화번호  : ");
        person.setNumber(scan.next());
 
        System.out.println();
 
        System.out.print("휴대폰번호  : ");
        person.setPhonenumber(scan.next());
        
        System.out.println();    
        
        return person;
    }
}