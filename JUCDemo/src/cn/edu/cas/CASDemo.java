package cn.edu.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(3);

        System.out.println(atomicInteger.compareAndSet(3,5)+"\t"+atomicInteger);
        System.out.println(atomicInteger.compareAndSet(7,9)+"\t"+atomicInteger);
    }
}
