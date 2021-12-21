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
            out.println("수를 결정하였습니다. 맞추어 보세요");

            for (int i = 0;; i++) {
                out.printf("%d - %d\n", min, max);
                out.print(i + 1 + ">>");
                int num = sc.nextInt();
                if (num > k) {
                    out.println("더 낮게");
                    max = num;
                } else if (num < k) {
                    out.println("더 높게");
                    min = num;
                } else if (num == k) {
                    out.println("맞았습니다.");
                    out.print("다시하시겠습니까(y/n)>>");
                    char select = sc.next().charAt(0);
                    if (select == 'y')
                        break;
                    else if (select == 'n')
                        return;
                    else
                        out.println("잘못입력하셨습니다.");
                }
            }
        }
	 }
	}