package cn.edu.wangyi;

import cn.edu.test.dfs;

import java.text.Format;
import java.util.Arrays;
import java.util.Scanner;

public class 第三题 {

    static double maxSum=0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        String tmpSt;
        String[] tmpArr;
        double[][] arr=new double[n][2];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            tmpSt=scanner.nextLine();
            tmpArr = tmpSt.split(",");
            arr[i][0]= Double.parseDouble((tmpArr[0]));
            arr[i][1]= Double.parseDouble((tmpArr[1]));
        }
        dfs(arr,0,m,0,n);

        System.out.println(String.format("%.4f",maxSum));

    }
    public static void dfs(double[][] arr, int curr, int m, double sum,int n){
        while (curr<n&&arr[curr][1]<=0){
            curr++;
        }
        if (curr>=n||m<=0) return;

        if (m-arr[curr][0]>=0){
            double tmp=arr[curr][0]*arr[curr][1];
            sum+=tmp;
            if (sum>maxSum) maxSum=sum;
            dfs(arr,curr+1, (int) (m-arr[curr][0]),sum,n);
            sum-=tmp;
        }
        dfs(arr,curr+1, m,sum,n);

    }
}
