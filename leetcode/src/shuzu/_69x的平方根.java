package shuzu;

public class _69x的平方根 {
    public static void main(String[] args) {
        System.out.println(new _69x的平方根().mySqrt(5));
    }
    public int mySqrt(int x) {
        if (x<0) return -1;
        int s=0;
        int e=(x>>1)+1;
        int mid;
        while (s<e){
            mid=s+((e-s)>>1);
            if (x==mid*mid) return mid;
            else if (mid==0||x/mid>=mid) s=mid+1;
            else e=mid-1;
        }
        return e*e<=x?e:e-1;
    }
}
