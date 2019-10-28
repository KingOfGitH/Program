package cn.edu.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> a=new AtomicStampedReference<>(10,1);
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\t"+a.getReference()+"\t"+a.getStamp());
            a.compareAndSet(10,2019,1,2);
            System.out.println(Thread.currentThread().getName()+"\t"+a.getReference()+"\t"+a.getStamp());
        },"AA").start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t"+a.getReference()+"\t"+a.getStamp());
            a.compareAndSet(10,12,1,2);
            System.out.println(Thread.currentThread().getName()+"\t"+a.getReference()+"\t"+a.getStamp());
            a.compareAndSet(12,10,2,3);
            System.out.println(Thread.currentThread().getName()+"\t"+a.getReference()+"\t"+a.getStamp());
        },"BB").start();
    }

    private static void aBA() {
        AtomicInteger a=new AtomicInteger(10);

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\t"+a);
            a.compareAndSet(10,13);
            System.out.println(Thread.currentThread().getName()+"\t"+a);
        },"AA").start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t"+a);
            a.compareAndSet(10,12);
            System.out.println(Thread.currentThread().getName()+"\t"+a);
            a.compareAndSet(12,10);
            System.out.println(Thread.currentThread().getName()+"\t"+a);
        },"BB").start();
    }
}
