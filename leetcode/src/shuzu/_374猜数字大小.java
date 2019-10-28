package shuzu;

public class _374猜数字大小 {
    public static void main(String[] args) {
        System.out.println(new _374猜数字大小().guessNumber(10));
    }
    public int guessNumber(int n) {
        if (guess(n)==0)return n;
        int s=n;
        int e=n;
        if (guess(n)>0){
            while (guess(e)>0){
                e=e*2;
            }
        }else {
            while (guess(s)<0){
                s=s/2;
            }
        }
        int mid=0;
        int flag;
        while (s<=e){
            mid=s+(e-s)/2;
            flag=guess(mid);
            if(flag==0) return mid;
            else if(flag>0) s=mid+1;
            else e=mid-1;
        }
        return mid;
    }

    private int guess(int n) {
        return Integer.compare(6,n);
    }

}
