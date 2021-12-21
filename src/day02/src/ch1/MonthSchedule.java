package ch1;
//7
import java.util.Scanner;

class Day {
   private String work; // �Ϸ��� �� ���� ��Ÿ���� ���ڿ�
   public void set(String work) { this.work = work; }
   public String get() { return work; }
   public void show() {
      if(work == null) System.out.println("�����ϴ�.");
      else System.out.println(work + "�Դϴ�.");
   }
}

public class MonthSchedule {
   private Scanner sc;
   private Day days[];
   
   MonthSchedule(int day) {
      this.days = new Day[day];
      for(int i=0; i<days.length; i++) {
         days[i] = new Day();
      }
      sc = new Scanner(System.in);
   }
   private void input() {
      System.out.print("��¥(1~30)?");
      int day = sc.nextInt();
      System.out.print("����(��ĭ�����Է�)?");
      String work = sc.next();
      day--;
      if(day < 0 || day > 30) { // 0~29
         System.out.println("��¥�� �߸� �Է��Ͽ����ϴ�.");
         return;
      }
      days[day].set(work);
   }
   private void view() {
      System.out.print("��¥(1~30)?");
      int day = sc.nextInt();
      day--;
      if(day < 0 || day > 30) { // 0~29
         System.out.println("��¥�� �߸� �Է��Ͽ����ϴ�.");
         return;
      }
      System.out.print((day+1)+"���� �� ���� ");
      days[day].show();
   }
   private void finish() {
      System.out.println("���α׷��� �����մϴ�.");
      sc.close();
   }
   public void run() {
      System.out.print("�̹��� ������ ���� ���α׷�.");
      while(true) {
         System.out.println();
         System.out.print("����(�Է�:1, ����:2, ������:3) >>");
         int select = sc.nextInt();
         switch(select) {
         case 1: input(); break;
         case 2: view(); break;
         case 3: finish(); return;
         }
      }
   }
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      MonthSchedule april = new MonthSchedule(30); // 4������ �� ��
      april.run();
   }

}
