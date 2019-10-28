package cn.edu;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class volatile情况 {
    public static void main(String[] args) {
        myData myData = new myData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.atomicAddPlusPlus();
                }
                System.out.println(Thread.currentThread().getName()+"\t data="+myData.atomicInteger);
            },String.valueOf(i)).start();
        }
        while (Thread.activeCount()>2){//后台进程大于2（一个main，一个GC）
            Thread.yield();//让出当前线程
        }
        System.out.println(Thread.currentThread().getName()+"\t data="+myData.data);
        System.out.println(Thread.currentThread().getName()+"\t atomicInteger="+myData.atomicInteger);
    }

    private static void volatile可见性() {
        myData myData = new myData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t data="+myData.data);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.add();
            System.out.println(Thread.currentThread().getName()+"\t data="+myData.data);
        },"AAA").start();

        while (myData.data==0){ }
        System.out.println(Thread.currentThread().getName()+"\t data="+myData.data);
    }

}
class myData{
    //去掉volatile关键字后，主线程一直等待
    volatile int data=0;

    public void add(){
        data=60;
    }
    /**
     * 解决办法
     * 1、加synchronized
     * 2、使用java.util.concurrent.atomic中的AtomicInteger 保证原子性
     */

    public void addPlusPlus(){
        data++;
    }

    AtomicInteger atomicInteger=new AtomicInteger();
    public void atomicAddPlusPlus(){
        atomicInteger.getAndIncrement();
    }
}
