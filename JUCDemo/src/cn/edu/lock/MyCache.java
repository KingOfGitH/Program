package cn.edu.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCache {
    private volatile Map<String ,Object> map=new HashMap<>();
    ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    public void put(String key,Object value){
//        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在写入"+key);
            //模拟网络拥堵
            try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            lock.writeLock().unlock();
        }

    }

    public void get(String key){
//        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在读取");
            //模拟网络拥堵
            try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成"+o);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            lock.readLock().unlock();
        }

    }
}
