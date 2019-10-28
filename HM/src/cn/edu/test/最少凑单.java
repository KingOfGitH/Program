package cn.edu.test;

import java.util.*;
 
 
public class 最少凑单 {
 
    private static int len = 0;
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int[] xs = new int[x+1];
        for(int i=0;i<=x;i++){
            xs[i]=10001;
        }
        for(int i=0;i<n;i++){
            int price = in.nextInt();
            for(int j=x;j>=0;j--){
                if(j>price){
                    //如果凑单价格大于当前price，那么就看下原来的凑单价最小还是
                    //当前菜品的价格，加上j-price的价格最少需要多少元凑单
                    xs[j] = Math.min(xs[j],xs[j-price]+price);
                }else{
                    //如果当前凑单价格小于等于price，必须点当前price的菜，除非有比当前价格更小的菜
                    xs[j] = Math.min(xs[j],price);
                }
            }
        }
        System.out.println(xs[x]);
    }
}