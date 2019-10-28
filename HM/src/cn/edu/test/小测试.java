package cn.edu.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 小测试 {

    public static void main(String args[]) {

        Integer a = 128; Integer b = 128;
        System.out.println(a==b);
//        int i=1,a=0,b=0,c=0,d=0;
//        switch (i){
//            default: c++;
//            case 1: a++ ;
//            case 2: b++ ;
//        }
//        a=i+++b;
//        System.out.println(a+" "+b+" "+i);
//        Thread t1=new Thread();
//        t1.run();
//        int arr[]=null;
//        String s="    a      ";
//        if (s==null|| s.length()<=0) System.out.println(0);
////        else System.out.println(s.split("\\s+").length);
//        String[] split = s.split("\\s");
//        System.out.println(Arrays.toString(split));
////        if (s.charAt(0)==' '){
////            s = s.substring(1, s.length());
////        }
////        if (s==null|| s.length()<=0) System.out.println(0);
////        if (s.charAt(s.length()-1)==' '){
////            s = s.substring(0, s.length()-1);
////        }
//        System.out.println("".equals(" "));
//        char aa='a';
//        a=aa;
//        char ab='b';
//        System.out.println(97^98);


//        String str1 = "hello";
//        String str2 = "he" + new String("llo");
//        String str3 = "he" + "llo";
//        String a="llo";
//        String str4= "he"+a;
//        System.out.println(str1 == str4);



//        List Listlist1 = new ArrayList();
//        Listlist1.add(0);
//        List Listlist2 = Listlist1;
//        System.out.println(Listlist1.get(0) instanceof Integer);
//        System.out.println(Listlist2.get(0) instanceof Integer);
    }




//    public static void main(String[] args) {
//        Integer s=new Integer(9);
//        Integer t=new Integer(9);
//        Long u=new Long(9);
//        System.out.println((t.equals(9)));
//        /**
//         * Integer a = 1000  它的内部就是这样的：   Integer i = Integer.valueOf(100);
//         * 而valueOf方法内部会去取缓存（默认范围 [-128, 127]） ，不会创建新对象。
//         */
//        Integer a = 1000, b = 1000;
//        System.out.println(a == b);//1 false
//        Integer c = 100, d = 100;
//        Integer e = 100;
//        System.out.println(c == d);//2 true
//        System.out.println(c==new Integer(100));
//    }
}
