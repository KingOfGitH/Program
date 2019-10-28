package cn.edu;

import java.util.concurrent.TimeUnit;

public class 指令重排1 {
    int a=0;
    boolean flag=false;
    public static void main(String[] args) {
        指令重排1 demo = new 指令重排1();
        new Thread(()->{
            demo.example2();
        },"B").start();

        new Thread(()->{
            demo.example1();
        },"A").start();


    }

    public void example1(){
        a=1;
        flag=true;
    }
    public void example2(){
        while (!flag){}
        if (flag){
            a=a+5;
            System.out.println("result="+a);
        }
    }
}
