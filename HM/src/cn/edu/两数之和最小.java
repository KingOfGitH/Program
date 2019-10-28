package cn.edu;

public class 两数之和最小 {
    public static void main(String[] args) {
        int n=1000000,m=10000000,k=100000000,a=0,b=0;
        if (n>m){
            a=m;
            m=n;
            n=a;
            a=0;
        }
        if (m<=k){
            while ((n-a)*m>k) a++;
        } else if (n>k){
           a=n;
        }else {
            while ((m-b)>k&&b<n) b++;
            if (n!=b) {
                while ((n-a)*(m-b)>k) a++;
            }
        }
        System.out.println(a+b);
    }
}
