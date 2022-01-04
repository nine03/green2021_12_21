package Ch07excercise05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

public class Ex05Main2 {
   public static final int MAX = 0;
   public static Scanner scan;
   private Vector<Student> sv = new Vector<Student>();
   private HashMap<String, Student> smap = new HashMap<String, Student>();
   {
      smap.put("황기태", new Student("황기태","모바일","1","4.1"));
      smap.put("이재문",new Student("이재문","안드로이드","2","3.9"));
      smap.put("김남윤",new Student("김남윤","웹공학","3","3.5"));
      smap.put("최찬미",new Student("최찬미","빅데이터","4","4.25"));
   }
   public Ex05Main2() {
      start();
   }
   private void start() {
      if(scan == null) {
         scan = new Scanner(System.in);
      }
      // 4명의 학생 정보 입력
      System.out.println("학생 이름, 학과, 학번, 학점평균 입력하세요.");
      for(int i=0; i<MAX; i++) {
         System.out.print(">> ");
         String info = scan.nextLine();
         StringTokenizer st = new StringTokenizer(info, ",");
         String 이름 = st.nextToken().trim();
         String 학과 = st.nextToken().trim();
         String 학번 = st.nextToken().trim();
         String 평균 = st.nextToken().trim();
         smap.put(이름, new Student(이름, 학과, 학번, 평균));
      }
      	//System.out.println(sv); // 입력된부분 확인용
//      Set<String> keys = smap.keySet();
//      Iterator<String> it = keys.iterator();
//      while(it.hasNext()) {
//         System.out.println("------------------------");
//         String key = it.next();
//         System.out.println(smap.get(key));
//      }
      // 정렬
      ArrayList<Student> sList = new ArrayList<Student>();
      sList.addAll( smap.values() );
      Collections.sort(sList, new Comparator<Student>() {
         @Override
         public int compare(Student o1, Student o2) {
            if(Integer.parseInt(o1.학번) < Integer.parseInt(o2.학번) ) {
               return 1;
            } else if(Integer.parseInt(o1.학번) > Integer.parseInt(o2.학번) ) {
               return -1;
            } else {
               return 0;
            }
         }
      });
      for(int i=0; i<sList.size(); i++) {
         System.out.println("------------------------");
         System.out.println(sList.get(i).toString(0));
      }
      // System.out.println(sList);
      // smap.values();
      System.out.println("------------------------");
   // 검색하는거 이름 입력 받아서 그만할때까지
      while(true) {
         System.out.print("학생이름 >> ");
         String 이름 = scan.nextLine();
         if("그만".equals(이름)) {
            break;
         }
         //IndexOf로 찾기
         Student std = smap.get(이름);
         if(std != null) {
            System.out.println(std);
         } else {
            System.out.println(이름 + " 학생은 없습니다!");
         }
      }
      System.out.println("프로그램 종료!!");
      scan.close();
   }
   public static void main(String[] args) {
      new Ex05Main2();
   }
}