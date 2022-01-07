package homework;

import java.util.ArrayList;
import java.util.List;

public class Manager {
  
    private List<Info> InfoList = new ArrayList<Info>();  // 개인정보 저장할 List
    private int PN = 0; // 개인별 고유번호 
 
    public List<Info> getInfoList(){
        return this.InfoList; // return 
    }
    
    public void setInfoList(List<Info> InfoList) {
        this.InfoList = InfoList;  // InfoList
    }
 
    public int addInfo(Info personInfo) { // personInfo 
      
        int ret = 0; // 성공여부 return 변수
 
        try {
            personInfo.setPN(++this.PN); // 고유번호 지정
            this.InfoList.add(personInfo); // List에 객체를 추가
        }catch(Exception e) {
            System.out.println("정보 추가 중 에러가 발생하였습니다." + "\n" + e.getMessage()); // return값 변경(0:정상 1:에러)
            ret = 1;
        }
        return ret;
    }

    public int removeInfo(int PN) {  // PN
        
        int ret = 0; // 성공여부 return 변수
        try {
            for(int idx=0; idx < this.InfoList.size(); idx++) { // List개수만큼 for문
                Info tempPersonInfo = this.InfoList.get(idx); 
                if(PN == tempPersonInfo.getPN()) {
                    this.InfoList.remove(idx); // 고유번호를 비교하고 같은 번호 삭제
                    break;
                }
                
                if(idx == this.InfoList.size()-1) {
                    ret = 2;
                }
            }
        }catch(Exception e) {
            System.out.println("정보 삭제 중 에러가 발생하였습니다." + "\n" + e.getMessage()); // return 값 변경(0:정상 1:에러 2: 해당정보없음)
            ret = 1;
        }
        return ret;
    }
    
    public int updateInfo(Info personInfo, int PN) { // PN personInfo
        int ret = 0; // 성공여부 return 변수
        
        try {
            for(int idx=0; idx < this.InfoList.size(); idx++) { // List개수만큼 for문
                Info tempPersonInfo = this.InfoList.get(idx);
 
                if(PN == tempPersonInfo.getPN()) {
                    personInfo.setPN(PN);
                    this.InfoList.remove(idx); // 고유 번호 비교후 같은 번호 수정
                    this.InfoList.add(idx, personInfo);
                    break;
                }
                if(idx == this.InfoList.size()-1) {
                    ret = 2;
                }
            }
        }catch(Exception e) {
            System.out.println("정보 수정 중 에러가 발생하였습니다." + "\n" + e.getMessage()); // return값 변경(0:정상 1:에러 2:해당정보없음)
            ret = 1;
        }
        return ret;
    }

    public void showInfo() {
        for(int idx=0; idx < this.InfoList.size(); idx++) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("고유번호 : " + this.InfoList.get(idx).getPN()
                                +"\n이름 : " + this.InfoList.get(idx).getName()
                                +"\n나이 : " + this.InfoList.get(idx).getAge()
                                +"\n성별 : " + this.InfoList.get(idx).getSex()
                                +"\n전화번호 : " + this.InfoList.get(idx).getNumber()
                                +"\n휴대폰번호 : " + this.InfoList.get(idx).getPhonenumber()
                                );
            System.out.println("-------------------------------------------------------------");
        }
    }
}