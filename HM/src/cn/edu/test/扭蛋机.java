package cn.edu.test;


import java.util.Scanner;
import java.util.Stack;

public class 扭蛋机 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        if (N<=0) return;
        Stack<Integer> list=new Stack<>();
        while (N>0){
            if (N%2==0){
                list.push(3);
                N=(N-2)/2;
            }else {
                list.push(2);
                N=(N-1)/2;
            }
        }
        while (list.size()>0) {
            System.out.print(list.pop());
        }
    }
}
