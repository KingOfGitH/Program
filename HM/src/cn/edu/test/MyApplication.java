package cn.edu.test;

class Test {
    private static int a=0;
    public static void hello() {
        a++;
        System.out.println("hello"+a);
    }
}
public class MyApplication {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test test=null;
        test.hello();
        test.hello();
        String s = "祝你考出好成绩！";
        System.out.println(s.length());
    }
}
