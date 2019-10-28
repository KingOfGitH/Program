package cn.edu;

public class Singleton {
    private volatile static Singleton singleton;
    private Singleton(){
        System.out.println(Thread.currentThread().getName()+"\t"+"构造函数私有化");
    }
    public static Singleton getInstance(){
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }

}
