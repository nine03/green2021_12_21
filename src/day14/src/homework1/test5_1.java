package homework1;

import java.util.*;
// 5 - 1번 문제
class Student{
    private String name, major;
    private String num;
    private String score;
    public Student(String name, String major, String num,String score) {
        this.name = name;
        this.major = major;
        this.num = num;
        this.score = score;
    }
    public String get_name() {
        return name;
    }
    public String get_major() {
        return major;
    }
    public String get_num() {
        return num;
    }
    public String get_score() {
        return score;
    }
    public void find_student(String name) {
        if(name.equals(this.name))
        System.out.println(name+","+major+","+num+","+score);
        
                }
    
}
public class test5_1 {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Student> a = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);
        Student[] stu = new Student[4];
        System.out.println("학생 이름, 학과, 학번, 학점평균을 입력하세요.");
        for(int i = 0; i < 4; i++) {
            System.out.print(">>");
            String text = scanner.nextLine();
            StringTokenizer st = new StringTokenizer(text,",");
            String name = st.nextToken().trim();
            String major = st.nextToken().trim();
            String num = st.nextToken().trim();
            String score = st.nextToken().trim();
            stu[i] = new Student(name, major, num,score);
            a.add(stu[i]);
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
            String name = scanner.next();
            if(name.equals("그만"))
                break;
            for (int i = 0;i<4;i++) {
                Student s = a.get(i);
                s.find_student(name);
            }
        }
        
    }
 
}
