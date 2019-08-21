package cn.edu.test;

import java.util.HashSet;
import java.util.Scanner;

public class dfs {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = Integer.parseInt(reader.nextLine());
        int ai = Integer.parseInt(reader.nextLine());
        int m = Integer.parseInt(reader.nextLine());
        int[][] relate = new int[n][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            String[] pair = reader.nextLine().split(",");
            int a = Integer.parseInt(pair[0]);
            int b = Integer.parseInt(pair[1]);
            if (a == ai || b == ai) {
                count++;
            }
            relate[a][b] = relate[b][a] = 1;
        }
        HashSet<Integer> set = new HashSet<>();
        boolean[] flags = new boolean[n];
        flags[ai] = true;
        dfs(ai, relate, set, flags);
        System.out.println(set.size() - count);
    }

    public static void dfs(int start, int[][] relate, HashSet<Integer> set, boolean[] flags) {
        for (int i = 0; i < relate.length; i++) {
            if (!flags[i] && i != start && relate[start][i] == 1) {
                flags[i] = true;
                set.add(i);
                dfs(i, relate, set, flags);
            }
        }
    }
}
