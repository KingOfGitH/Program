package cn.edu.test;


import java.util.Date;
public class SuperTest extends Date{
    private static final long serialVersionUID = 1L;
    private void test(){
        System.out.println(super.getClass().getName());
    }

    public static void main(String[]args){
        String s1=new String("xyz");
        String s2=new String("xyz");
        Boolean b1=s1.equals(s2);
        Boolean b2=(s1==s2);
        System .out.print(b1+ "” ”" +b2);
    }
}
