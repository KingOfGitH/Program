package cn.edu.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Phone phone=new Phone();
        new Thread(phone::get,"t1").start();
        new Thread(phone::get,"t2").start();
        for (int i = 0; i < 10; i++) {
            new Thread(phone::set,String.valueOf(i)).start();
        }
    }
}
