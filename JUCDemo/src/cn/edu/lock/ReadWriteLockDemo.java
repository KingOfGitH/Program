package cn.edu.lock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache=new MyCache();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                myCache.put(String.valueOf(finalI),finalI);
            },String.valueOf(i)).start();;
        }

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                myCache.get(String.valueOf(finalI));
            },String.valueOf(i)).start();;
        }

    }
}
