package cn.edu.second;

public class 发最少工资 {
    public static void main(String[] args) {
        int N=6;
        int[] a={9,9,9,9,9,9};
        System.out.println(minMoney(N,a));

    }
    public static int minMoney(int N,int[] a){
        int money=0;
        int min=100;
        int flag=0;
        for (int i = 0; i < a.length; i++) {
            flag+=a[i];
            if (a[i]!=0){
                if (a[i]<min){
                    min=a[i];
                }
            }
        }
        while (flag>0){
            min=100;
            for (int i = 0; i < a.length; i++) {
                if (a[i]!=0){
                    if (a[i]<min){
                        min=a[i];
                    }
                }
            }
            for (int i = 0; i < a.length; i++) {
                if (a[i]!=0){
                    money+=100;
                    a[i]-=min;
                    flag-=min;
                }
            }
        }
         return money;
    }

}
