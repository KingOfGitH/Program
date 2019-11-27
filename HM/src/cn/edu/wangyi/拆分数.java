package cn.edu.wangyi;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 拆分数 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        scanner.close();

        if (m==2){
            System.out.println(1);
            return;
        }
        int res=1;
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(m);
        while ((res=queue.element())>3){
            queue.poll();
            queue.add(res/2);
            queue.add(res-res/2);
        }
        res=1;
        int maxValue = Integer.MAX_VALUE;
        int tmp=queue.poll();
        while (!queue.isEmpty()&&res<maxValue/tmp){
            res*=tmp;
            tmp=queue.poll();
        }
        if (res<maxValue/tmp) System.out.println(res*tmp);
        else System.out.println(maxValue);
    }
}
