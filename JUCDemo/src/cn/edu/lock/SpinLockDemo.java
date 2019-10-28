package cn.edu.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {
    AtomicReference<Thread> atomicReference=new AtomicReference<>();

    public void myLock(){
        Thread thread=Thread.currentThread();
        System.out.println(thread.getName()+"\t myLock");
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }
    public void myUnLock(){
        Thread thread=Thread.currentThread();
        System.out.println(thread.getName()+"\t myUnLock");
        atomicReference.compareAndSet(thread,null);
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                spinLockDemo.myUnLock();
            }
        },"AA").start();

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                spinLockDemo.myUnLock();
            }
        },"BB").start();
    }
}
