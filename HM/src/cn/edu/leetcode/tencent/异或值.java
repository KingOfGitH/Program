package cn.edu.leetcode.tencent;

import java.util.*;

import static java.lang.Math.abs;

public class 异或值 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] ai=new int[n];
        Map<Integer,Integer> mapA=new HashMap<>();
        Map<Integer,Integer> mapB=new HashMap<>();
        int[] bi=new int[n];
        for (int i = 0; i < n; i++) {
            ai[i]=scanner.nextInt();
            if (!mapA.containsKey(ai[i])) mapA.put(ai[i],1);
            else mapA.put(ai[i],mapA.get(ai[i])+1);
        }
        for (int i = 0; i < n; i++) {
            bi[i]=scanner.nextInt();
            if (!mapB.containsKey(bi[i])) mapB.put(bi[i],1);
            else mapB.put(bi[i],mapB.get(bi[i])+1);
        }

        int tmp;
        int res=0;
        for (int i = 0; i < n; i++) {
            tmp = mapA.get(ai[i]);
            if (tmp %2==1){
                mapA.put(ai[i],0);
            }else {
                ai[i]=-1;
            }
        }
        for (int i = 0; i < n; i++) {
            tmp = mapB.get(bi[i]);
            if (tmp %2==1){
                mapB.put(bi[i],0);
            }else {
                bi[i]=-1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (ai[i]!=-1){
                for (int j = 0; j < n; j++) {
                    if (bi[j]!=-1){
                        res^=(ai[i]+bi[j]);
                    }
                }
            }

        }
        System.out.println(res);
    }
}
