package cn.edu.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class 测试父子静态构造关系 {
//    public static void main(String[] args) {
//        Son son1 = new Son();
//        System.out.println("===================");
//
//        System.out.println(son1.a);
//        System.out.println(son1.fatherPublicMember);
////        int a = Son.a;
////        Son son2 = new Son();
//    }
    public static void main(String[] args) throws Exception {
        Class aClass = Class.forName("cn.edu.test.Son");
        System.out.println("===================");
        Son son1 = (Son) aClass.newInstance();
        System.out.println("===================");
        System.out.println("Class Name is "+aClass.getName());

        System.out.println("===================");
        Method sayHello = aClass.getDeclaredMethod("sayHello", String.class);
        sayHello.invoke(son1,"两者都可以访问");

        System.out.println("===================");
        Method sayFatherHello = aClass.getDeclaredMethod("sayFatherHello", String.class);
        sayFatherHello.invoke(son1,"abstract可以访问");

        System.out.println("===================");
        Method sayInterfaceHello = aClass.getDeclaredMethod("sayInterfaceHello", String.class);
        sayInterfaceHello.invoke(son1,"interface可以访问");

        System.out.println("=========注意这里无法使用getDeclaredMethod==========");
        Method sayPublicFather = aClass.getMethod("sayPublicFather");
        sayPublicFather.invoke(son1);

        System.out.println("===================");
        Method sayPrivateFather = aClass.getDeclaredMethod("sayPrivateFather");
        sayPrivateFather.setAccessible(true);
        sayPrivateFather.invoke(son1);

        System.out.println("==========fatherPublicMember=========");
        Field fatherPublicMember = aClass.getField("fatherPublicMember");
        fatherPublicMember.set(son1,"嘿嘿嘿");
        sayPublicFather.invoke(son1);

        System.out.println("==========fatherPrivateMember=========");
        Field fatherPrivateMember = aClass.getDeclaredField("fatherPrivateMember");
        fatherPrivateMember.setAccessible(true);
//        fatherPrivateMember.set(son1,"嘿嘿嘿");
//        sayPublicFather.invoke(son1);
    }
}
