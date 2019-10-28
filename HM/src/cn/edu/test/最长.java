package cn.edu.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.max;

public class 最长 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        List<Integer> list = find(s);
        if (list.size()==1){
            System.out.print(list.get(0));
        }else if (list.size()>1){
            System.out.print(list.get(0)+" ");
            for (int i = 0; i < list.size()-2; i++) {
                System.out.print(list.get(i+1)-list.get(i)+" ");
            }
            System.out.print(list.get(list.size()-1)-list.get(list.size()-2));
        }
        scanner.close();
    }
    public static List<Integer> find(String s){
        List<Integer> res=new ArrayList<>();
        int[] asc=new int[128];
        for (int i = 0; i < s.length(); i++) {
            asc[s.charAt(i)]=i;
        }
        int a=0;
        int b=0;
        for (int i = 0; i < s.length(); i++) {
            b=max(b,asc[s.charAt(i)]);
            if (i==b){
                res.add(b-a+1);
                a=b-i;
            }
        }
        return res;
    }
}
