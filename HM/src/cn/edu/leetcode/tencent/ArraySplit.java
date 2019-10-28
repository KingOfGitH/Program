package cn.edu.leetcode.tencent;

import java.util.Scanner;

public class ArraySplit {
    static void avgSum(int[] arr, int[][][] a, int n, int sum) {
        for (int i = 0; i < sum / 2 + 1; i++) {
            a[0][0][i] = 0;
            a[1][0][i] = 0;
        }
        for (int i = 0; i < n / 2 + 1; i++) {
            a[0][i][0] = 0;
            a[1][i][0] = 0;
        }
        int skip;
        int take;
        for (int i = 1; i < n + 1; i++) {
            int max = Math.min(i, n / 2);
            for (int j = 1; j <= max; j++) {
                for (int k = 1; k < sum / 2 + 1; k++) {
                    skip = a[(i - 1) % 2][j][k];
                    take = k < arr[i - 1] ? 0 :
                            a[(i - 1) % 2][j - 1][k - arr[i - 1]] + arr[i - 1];
                    a[i % 2][j][k] = Math.max(take, skip);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T=scanner.nextInt();
        int res[][]=new int[T][2];
        int sum;
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            sum = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
                sum += arr[j];
            }
            int[][][] a = new int[2][n / 2 + 1][sum / 2 + 1];
            avgSum(arr, a, n, sum);
            res[i][0] = a[n % 2][n / 2][sum / 2];
            res[i][1] =sum-res[i][0];
        }
        for (int i = 0; i < T; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }

    }
}
