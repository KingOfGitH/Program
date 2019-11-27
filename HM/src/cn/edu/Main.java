package cn.edu;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(find(1,3000));
    }
    public static int find(int begin,int num){
        int res=num,bit=1;
        while (res/10>0){
            bit++;
            res/=10;
        }
        int[] arr=new int[bit];
        arr[0]=1;
        int tmp=10;
        for (int i = 1; i < bit; i++) {
            arr[i]=8*arr[i-1]+tmp;
            tmp*=10;
        }
        System.out.println(Arrays.toString(arr));
        int nums[]=new int[bit];
        res=num;
        for (int i = 0; i < bit; i++) {
            nums[i]=res%10;
            res/=10;
        }
        int b=0;
        for (int i = bit-1; i > 0; i--) {
            if (nums[i]==4){
//                b+=nums[i]%
                b+=nums[i]*Math.pow(10,i);
            }else
        }
        int a;
        for (int i = 1; i < bit; i++) {
            a=num/tmp;
            if (a<4){
                res+=arr[bit-i-1]*a;
            }else if(a>4){
                res+=(arr[bit-i-1]*(a-1)+tmp*10);
            }else {
                res+=arr[bit-i-1]*3+num%tmp;
                break;
            }
            num%=10;
            tmp/=10;
        }
        return res;
    }
}
