package cn.edu.test;

import java.util.Arrays;

public class 特殊分组 {
    public static void main(String[] args) {
        int m=12,n=6;
        int[] a={1,5,3,3,3,4,3,5,3,2,3,3};
        int count=0;
        int[] b=new int[n];
        int[][] c=new int[n][2];
        int j=0;
        for (int i = 0; i < m; i++) {
            b[a[i]-1]++;
        }
        if (n<3){
            for (int i = 0; i < b.length; i++) {
                count+=b[i]/3;
            }
            System.out.println(count);
            return;
        }
        System.out.println(Arrays.toString(b));
        for (int i = 0; i < n; i++) {
            if ((c[j][0]=b[i])!=0) c[j][1]++;
            while (i < n-1&&b[i]==b[i+1]){
                c[j][0]=b[i];
                c[j][1]++;
                i++;
            }
            j++;
            System.out.println(Arrays.toString(c[j-1]));
        }
        boolean flag=true;
        while (flag){
            flag=false;
            int tmp=0;
            if ((tmp=c[0][0]-c[1][0])>=3){
                tmp/=3;
                count+=tmp*c[0][1];
                c[0][0]-=3*tmp;
            }
            for (int i = 1; i < n-1; i++) {
                if ((tmp=Math.min((c[i][0]-c[i-1][0]),(c[i][0]-c[i+1][0])))>=3){
                    tmp/=3;
                    count+=tmp*c[i][1];
                    c[i][0]-=3*tmp;
                    flag=true;
                }
            }
            if ((tmp=c[n-1][0]-c[n-2][0])>=3){
                tmp/=3;
                count+=tmp*c[n-1][1];
                c[n-1][0]-=3*tmp;
            }
        }
        for (int i = 0; i < n-1; i++) {
            System.out.println(Arrays.toString(c[i]));
        }

        j=0;
        for (int i = 0; i < n; i++) {
            int tmp=c[j][0];
            b[i]=tmp;
            for (int k = 1; k < c[j][1]; k++) {
                i++;
                tmp=c[j][0];
                b[i]=tmp;
            }
            j++;
        }
        System.out.println(Arrays.toString(b));
        for (int i = 0; i < n-2; i++) {
            while (b[i]!=0&&b[i+1]!=0&&b[i+2]!=0){
                count++;
                b[i]--;
                b[i+1]--;
                b[i+2]--;
            }
        }
        System.out.println(count);
    }
}
