package cn.edu.test;

class Son extends Father implements Interface {
    static {
        System.out.println("子类静态代码块1");
    }
    public static int a = Help.sonStaticMemberVarInit();
    static {
        System.out.println("子类静态代码块2");
    }
    {
        System.out.println("子类普通代码块1");
    }
    private int b = Help.sonMemberVarInit();
    {
        System.out.println("子类普通代码块2");
    }
    public Son() {
        // super(2018);
        System.out.println("子类构造方法");
    }



//    public String fatherPublicMember="子类覆盖父类Public普通成员";

    private String fatherPrivateMember="无法覆盖父类Private普通成员";

    @Override
    public void sayHello(String s) {
        System.out.println("Son实现Interface和Father：Hello "+s);
    }

    @Override
    public void sayFatherHello(String s) {
        System.out.println("Son实现FatherHello：Hello "+s);
    }

    @Override
    public void sayInterfaceHello(String s) {
        System.out.println("Son实现InterfaceHello：Hello "+s);
    }

    public void sayPublicFather() {
        System.out.println("Son override 父类public方法 "+fatherPublicMember);
    }

    private void sayPrivateFather() {
        System.out.println("私有方法无法覆盖");
    }
}