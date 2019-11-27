package cn.edu.wangyi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 特殊败絮 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String a=scanner.nextLine();
        String b=scanner.nextLine();
        scanner.close();
        String[] a1 = a.split("\\s");
        String[] b1 = b.split("\\s");
        int n=a1.length;
        int[] num1=new int[n];
        int[][] num2=new int[n][2];
        for (int i = 0; i < n; i++) {
            num1[i]=Integer.parseInt(a1[i]);
            num2[i][0]=i;
            num2[i][1]=Integer.parseInt(b1[i]);
        }
        Comparator comparator=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int[] s1= (int[]) o1;
                int[] s2= (int[]) o2;
                return Integer.compare(s1[1], s2[1]);
            }
        };
        Arrays.sort(num1);
        Arrays.sort(num2,comparator);
        int[] res=find(num1, num2, n);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i]+" ");
        }
        System.out.println();

    }
    public static int[] find(int[] num1,int[][] num2,int n){
        int b1=0,e1=0,b2=n-1,e2=n-1;
        int flag=0;
        int[] res=new int[n];
        while(flag++<n) {
            if(num1[b1]>num2[e1][1]) {
                res[num2[e1][0]]=num1[b1];
                b1++;
                e1++;
            } else if(num1[b1]<num2[e1][1]) {
                res[num2[e2][0]]=num1[b1];
                e2--;
                b1++;
            } else if(num1[b1]==num2[e1][1]) {
                if(num1[b2]>num2[e2][1]) {
                    res[num2[e2][0]]=num1[b2];
                    b2--;
                } else {
                    res[num2[e2][0]]=num1[b1];
                    b1++;
                }
                e2--;
            }
        }
        return res;
    }

}
