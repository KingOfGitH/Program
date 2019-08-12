package cn.edu.second;

public class 求a的n次幂 {
    public static void main(String[] args) {
        long now1=System.currentTimeMillis();
        System.out.println(power(1,20));
        long now2 = System.currentTimeMillis();
        System.out.println("当前程序耗时："+(now2-now1)+"ms");

    }
    static int pow(int a,int n){
        if (n==0) return 1;
        int res=a;
        int flag=1;
        while (flag<<1<n){
            res=res*res;
            flag<<=1;
        }
        return res*pow(a,n-flag);
    }
    static int power(int a,int n){
        if (n==0) return 1;
        if (n%2==0) return power(a,n/2)*power(a,n/2);
        else return a*power(a,(n-1)/2)*power(a,(n-1)/2);
    }
}
