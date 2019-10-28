package other;

public class _7整数反转 {
    public int reverse(int x) {
        long y=0;
        while (x!=0){
            y=y*10+x%10;
            x/=10;
        }
        return y>Integer.MAX_VALUE?0:y<Integer.MIN_VALUE?0:(int)y;
    }
}
