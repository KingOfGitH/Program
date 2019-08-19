package cn.edu.test;

public interface Interface {
    static int interfaceA=Help.interfaceStaticMemberVarInit();
    int interfaceB=Help.interfaceMemberVarInit();
    public void sayHello(String s);
    public void sayInterfaceHello(String s);
}
