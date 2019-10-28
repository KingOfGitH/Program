import java.util.Scanner;

import static java.lang.Math.max;

public class bijijingxuan {
    public static int[] maxSum(int[] a) {
        int [] b=new int[a.length];
        a[1]=max(a[0],a[1]);
        b[0]=1;b[1]=1;
        int tmp1;
        int tmp2;
        for (int i = 2; i < a.length; i++) {
            tmp1=max(a[i],a[i-1]);
            tmp2=a[i-2]+a[i];
            if (tmp1>tmp2){
                if (a[i]>=a[i-1]){
                    b[i]=1;
                }else {
                    b[i]=b[i-1];
                }
                a[i]=tmp1;
            }else{
                a[i]=tmp2;
                b[i]=b[i-2]+1;
            }
        }
        return new int[]{a[a.length-1],b[a.length-1]};
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int [] a= new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextInt();
        }
        int[] maxSum = maxSum(a);
        System.out.println(maxSum[0]+" "+maxSum[1]);
    }
}
