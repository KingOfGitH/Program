package cn.edu.test;
class Help {
    public static int fatherStaticMemberVarInit() {
        System.out.println("父类静态成员变量");
        return 8;
    }
    public static int fatherMemberVarInit() {
        System.out.println("父类普通成员变量");
        return 8;
    }
    public static int sonStaticMemberVarInit() {
        System.out.println("子类静态成员变量");
        return 6;
    }
    public static int sonMemberVarInit() {
        System.out.println("子类普通成员变量");
        return 6;
    }
}
 