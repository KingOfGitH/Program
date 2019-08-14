package cn.edu.test;
abstract class Father {
    public Father() {
        System.out.println("父类无参构造方法");
    }
    static {
        System.out.println("父类静态代码块1");
    }
    public static int a = Help.fatherStaticMemberVarInit();
    static {
        System.out.println("父类静态代码块2");
    }
    {
        System.out.println("父类普通代码块1");
    }
    private int b = Help.fatherMemberVarInit();
    {
        System.out.println("父类普通代码块2");
    }
    public Father(int v) {
        System.out.println("父类带参构造方法");
    }

    public String fatherPublicMember="父类Public普通成员";

    private String fatherPrivateMember="父类Private普通成员";

    public abstract void sayHello(String s);

    public abstract void sayFatherHello(String s);


    public void sayPublicFather(){
        System.out.println("父类public方法可以访问？");
    }

    private void sayPrivateFather(){
        System.out.println("父类private方法可以访问？");
    }

//    public static void main(String[] args) {
//        Son son1 = new Son();
//        System.out.println("===================");
//
//        son1.sayPrivateFather();
//        System.out.println(son1.fatherPublicMember);
//    }
}