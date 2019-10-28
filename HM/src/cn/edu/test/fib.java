package cn.edu.test;

public class fib {
    public static void main(String[] args) {
        System.out.println(fib(4));
    }
    public static int fib(int n){
        if (n==0) return 1;
        if (n==1) return 1;
        int i=1,j=1;
        for (int k = 2; k <= n; k++) {
            if (k%2==0){
                j=i+j;
            }else {
                i=i+j;
            }
        }
        return n%2==0?j:i;
    }
}
