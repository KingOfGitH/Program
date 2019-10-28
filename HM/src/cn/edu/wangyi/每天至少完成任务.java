package cn.edu.wangyi;

import java.util.Arrays;

public class 每天至少完成任务 {
    public static void main(String[] args) {
        int n=3;
        int[][] arr=new int[n][2];
        arr= new int[][]{{1, 2}, {0}, {1, 2}};
        int fangWen[]=new int[n];
        int res[]=new int[n];
        for (int i = 0; i < n; i++) {
            if (fangWen[i]==0) {
                fangWen[i]=1;
                res[i]++;
            }
            for (int j = 1; j < arr[i][0]+1; j++) {
                if (fangWen[arr[i][j]-1]==0){
                    res[i]++;
                    fangWen[arr[i][j]-1]=1;
                }
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
