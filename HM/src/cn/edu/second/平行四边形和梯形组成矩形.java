package cn.edu.second;

/**
 * 平行四边形1*1 直角梯形 （1+2）*1
 * 组成1*N的矩形
 */
public class 平行四边形和梯形组成矩形 {
    public static void main(String[] args) {
        int N=7;
        int s=0;
        for (int i = 1; i <= N/3; i++) {
            for (int j = 0; j <=N - 3; j++) {
                if (N==(i*3+j)){
                    System.out.println(i+","+j);
                    s+=combinationSec(j,i+j-1);
                }
            }
        }
        s*=2;
        System.out.println(s);
    }


    //******优化排列组合*******//

    /**
     * 替换阶乘的另一种方式(从n开始递减相乘，乘m个数)
     * @param n
     * @param m
     * @return
     */
    private static long factorialSec(int m, int n) {
        long sum = 1;

        while(m > 0 && n > 0) {
            sum = sum * n--;
            m--;
        }
        return sum;
    }
    /**
     * 排列
     * @param m
     * @param n
     * @return
     */
    public static long arrangementSec(int m, int n) {
        return m <= n ? factorialSec(m, n) : 0;
    }
    /**
     * 组合
     * @param m
     * @param n
     * @return
     */
    public static long combinationSec(int m, int n) {
        if( m > n )
            return 0;
        if( m > n/2 )
        {
            m = n - m;
        }
        return factorialSec(m, n)/factorialSec(m, m);
    }
    //******优化结束******//

}
