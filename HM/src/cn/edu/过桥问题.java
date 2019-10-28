package cn.edu;

import java.util.Arrays;
import java.util.Scanner;


public class 过桥问题 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        if (n==0) System.out.println(0);
        else {
            int time[] = new int[n];
            for (int i = 0; i < n; i++) {
                time[i] = scanner.nextInt();
            }
            if (n < 3) {
                System.out.println(n == 2 ? Math.max(time[0], time[1]) : time[0]);
            }
            Arrays.sort(time);
            int min1 = time[0];
            int min2 = time[1];
            int flag = n;
            int res = 0;
            while (flag > 3) {
                res += min2 + min1 + time[flag - 1] + min2;
                flag -= 2;
            }
            if (flag == 2) res += min2;
            else if (flag == 1) res += min1;
            else {
                res += min1 + min2 + time[2];
            }
            System.out.println(res);
        }
    }
}
