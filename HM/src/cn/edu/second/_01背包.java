package cn.edu.second;

import java.util.Scanner;

import static java.lang.Math.max;

public class _01背包 {
    private static int[] w ;
    private static int[] v ;
    private static int n;
    private static int M;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n = scanner.nextInt();
        M=scanner.nextInt();
        w=new int[n];
        v=new int[n];
        for (int i = 0; i < n; i++) {
            w[i]=scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v[i]=scanner.nextInt();
        }
        int result = maxSum();
        System.out.println(result);
    }
    static int maxSum() {
        int[][] max = new int[n][M + 1];
        for (int i = 0; i < M + 1; i++) {
            if (i >= w[0]) {
                max[0][i] = v[0];
            } else {
                max[0][i] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < M + 1; j++) {
                if (j >= w[i]) {
                    int a = v[i] + max[i - 1][j - w[i]];
                    int b = max[i - 1][j];
                    max[i][j] = max(a, b);
                } else {
                    max[i][j] = max[i - 1][j];
                }
            }
        }
        return max[n - 1][M];
    }
}
