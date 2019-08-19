package cn.edu.test;

import java.util.Arrays;

public class N个三角形有多少个全等 {
    public static void main(String[] args) {
        int N=3;
        int[][] arr=new int[N][6];
        int count=0;
        arr= new int[][]{{0,0,0,1,1,0}, {0,0,0,1,1,1}, {0,0,0,2,1,1}};
        double a[][]=new double[N][3];
        for (int i = 0; i < N; i++) {
            a[i][0]=Math.sqrt(Math.pow((arr[i][2]-arr[i][0]),2)+Math.pow((arr[i][3]-arr[i][1]),2));
            a[i][1]=Math.sqrt(Math.pow((arr[i][4]-arr[i][0]),2)+Math.pow((arr[i][5]-arr[i][1]),2));
            a[i][2]=Math.sqrt(Math.pow((arr[i][4]-arr[i][2]),2)+Math.pow((arr[i][5]-arr[i][3]),2));
            插入排序(a[i]);
        }
        System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.toString(a[1]));
        System.out.println(Arrays.toString(a[2]));
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (a[i][0]==a[j][0] && a[i][1]==a[j][1] &&a[i][2]==a[j][2]){
                    count++;
                }
            }
        }
        System.out.println(count);

    }
    
    public static void 插入排序(double[] arr){
        int i, j;
        int n = arr.length;
        double target;

        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
        for (i = 1; i < n; i++)
        {
            j = i;
            target = arr[i];

            while (j > 0 && target < arr[j - 1])
            {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
        }
    }
}
