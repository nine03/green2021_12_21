package org.comstudy21.saram.model;

import org.comstudy21.saram.SaramMain;

// 루즈 커플링
// 결합도 낮추고 응집력 높여라.
// SOLID 5원칙
public class SaramDao {
   // 임시로 배열에 저장하도록 구현한후 DB연동 또는 FileIO로 처리
   private static final int MAX = 100;
   private static final SaramVo[] saramArr = new SaramVo[MAX];
   public static int top = 0;
   public static int sequenceNo = 1; // 절대로 감소 되지 않는다.
   // static 초기화 블럭
   static {
      saramArr[top++] = new SaramVo(sequenceNo++, "KIM","010-1111-1111","kim@comstudy.org");
      saramArr[top++] = new SaramVo(sequenceNo++, "LEE","010-2222-2222","lee@comstudy.org");
      saramArr[top++] = new SaramVo(sequenceNo++, "PARK","010-3333-3333","park@comstudy.org");
   }
   
   // 전체 출력
   public SaramVo[] selectAll() {
      // saramArr와 참조 끊기 - 새 배열과 새 객체가 필요하다.
      SaramVo[] newArr = new SaramVo[top];
      for(int i=0; i<newArr.length; i++) {
         // 새로 만든 객체에 값만 올겨 담기.
         SaramVo newSaram = new SaramVo();
         newSaram.setNo(saramArr[i].getNo());
         newSaram.setName(saramArr[i].getName());
         newSaram.setPhone(saramArr[i].getPhone());
         newSaram.setEmail(saramArr[i].getEmail());
         newArr[i] = newSaram;
      }
      return newArr;
   }
   // 상세보기 - 이름으로 검색
   public SaramVo selectOne(SaramVo vo) {
      // 1. 검색하기
      // 2. 같은 요가가 존재 하면 복재해서 반환(return)
      for(int i=0; i<top; i++) {
         if(vo.getName().equals(saramArr[i].getName())) {
            SaramVo newSaram = new SaramVo();
            newSaram.setNo(saramArr[i].getNo());
            newSaram.setName(saramArr[i].getName());
            newSaram.setPhone(saramArr[i].getPhone());
            newSaram.setEmail(saramArr[i].getEmail());
            return newSaram;
         }
      }
      return null;
   }
   // 상세보기 - 이름으로 검색
   public SaramVo selectByNo(int no) {
      // 1. 검색하기
      // 2. 같은 요가가 존재 하면 복재해서 반환(return)
      for(int i=0; i<top; i++) {
         if(no  == saramArr[i].getNo()) {
            SaramVo newSaram = new SaramVo();
            newSaram.setNo(saramArr[i].getNo());
            newSaram.setName(saramArr[i].getName());
            newSaram.setPhone(saramArr[i].getPhone());
            newSaram.setEmail(saramArr[i].getEmail());
            return newSaram;
         }
      }
      return null;
   }
   // 입력
   public void insert(SaramVo vo) {
      if(top >= MAX) {
         System.out.println(">>> 더이상 입력이 불가능합니다!");
         return;
      }
      vo.setNo(sequenceNo++);
      saramArr[top++] = vo;
   }
   // 수정
   public void update(SaramVo vo) {
      // 검색해서 같은 요소가 있다면 수정하기, no로 검색해서 index를 찾기
      for(int i=0; i<top; i++) {
         if(saramArr[i].getNo() == vo.getNo()) {
            saramArr[i] = vo;
         }
      }
   }
   // 삭제 
   public void delete(SaramVo vo) {
      // 1. no로 검색하기
      // 2. 같은 요소가 있다면 한칸식 땡기기
      // 3. 마지막 요소는 null로 변경하고 top감소
      for(int i=0; i<top; i++) {
         if(saramArr[i].getNo() == vo.getNo()) {
            for(int j=i; j<top-1; j++) {
               saramArr[j] = saramArr[j+1];
            }
            saramArr[top-1] = null;
            top--;
         }
      }
   }
}
