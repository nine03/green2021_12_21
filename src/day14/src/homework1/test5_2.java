package homework1;

import java.util.*;
// 5 - 2번 문제
public class test5_2 {
	 
    public static void main(String[] args) {
        HashMap<String,Student> dic = new HashMap<String,Student>();
        Scanner sc = new Scanner(System.in);
        Student[] stu = new Student[4];
        System.out.println("학생 이름, 학과, 학번, 학점평균을 입력하세요.");
        for(int i = 0; i < 4; i++) {
            System.out.print(">>");
            String text = sc.nextLine();
            StringTokenizer st = new StringTokenizer(text,",");
            String name = st.nextToken().trim();
            String major = st.nextToken().trim();
            String num = st.nextToken().trim();
            String score = st.nextToken().trim();
            stu[i] = new Student(name, major, num,score);
            dic.put(name,stu[i]);
        }
        for(int i = 0; i < 4; i++) {
            System.out.println("-----------------------------");
            System.out.println("이름 : " + stu[i].get_name());
            System.out.println("학과 : " + stu[i].get_major());
            System.out.println("학번 : " + stu[i].get_num());
            System.out.println("학점평균 : "+ stu[i].get_score());
            System.out.println("-----------------------------");
        }
        while(true) {
            System.out.print("학생 이름>>");
            String name = sc.next();
            if(name.equals("그만"))
                break;
            Student s = dic.get(name);
            s.find_student(name);
        }
    }
}