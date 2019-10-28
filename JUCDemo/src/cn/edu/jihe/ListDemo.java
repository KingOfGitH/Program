package cn.edu.jihe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ListDemo {
    public static void main(String[] args) {
//        Map<Integer,Integer> a=Collections.synchronizedMap(new HashMap<>());
//        Map<Integer,Integer> a=new Hashtable<>();
        Map<Integer,Integer> a=new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(() -> {
                a.put(finalI,finalI);
                System.out.println(a);
            },String.valueOf(i)).start();
        }
    }

    private static void set不安全() {
        //        Set<Integer> a=new CopyOnWriteArraySet<>();
//        Set<Integer> a=new HashSet<>();
        Set<Integer> a= Collections.synchronizedSet(new HashSet<>());
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(() -> {
                a.add(finalI);
                System.out.println(a);
            },String.valueOf(i)).start();
        }
    }

    private static void list不安全() {
        //        List<Integer> a=new ArrayList<>();
//        List<Integer> a=new Vector<>();
//        List<Integer> a= Collections.synchronizedList(new ArrayList<>());
        List<Integer> a=new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(() -> {
                a.add(finalI);
                System.out.println(a);
            },String.valueOf(i)).start();
        }
//        System.out.println(a);
    }
}
