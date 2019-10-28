package cn.edu.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Phone {
    ReentrantLock lock=new ReentrantLock();
    public synchronized void sendSMS(){
        System.out.println(Thread.currentThread().getName()+"\t sendSMS");
        sendEmail();
    }
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"\t sendEmail");
    }

//    @Override
//    public void run() {
//        get();
//    }

    void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t get()");
            set();
        }finally{
            lock.unlock();
        }
    }
    void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t set()");
        }finally{
            lock.unlock();
        }
    }
}
