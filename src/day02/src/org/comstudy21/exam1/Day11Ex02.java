package org.comstudy21.exam1;

import java.util.Scanner;
import java.util.Random;
import static java.lang.System.out;

public class Day11Ex02 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        Random r = new Random();

        while (true) {
            int k = r.nextInt(100);
            int min = 0, max = 99;
            out.println("���� �����Ͽ����ϴ�. ���߾� ������");

            for (int i = 0;; i++) {
                out.printf("%d - %d\n", min, max);
                out.print(i + 1 + ">>");
                int num = sc.nextInt();
                if (num > k) {
                    out.println("�� ����");
                    max = num;
                } else if (num < k) {
                    out.println("�� ����");
                    min = num;
                } else if (num == k) {
                    out.println("�¾ҽ��ϴ�.");
                    out.print("�ٽ��Ͻðڽ��ϱ�(y/n)>>");
                    char select = sc.next().charAt(0);
                    if (select == 'y')
                        break;
                    else if (select == 'n')
                        return;
                    else
                        out.println("�߸��Է��ϼ̽��ϴ�.");
                }
            }
        }
	 }
	}