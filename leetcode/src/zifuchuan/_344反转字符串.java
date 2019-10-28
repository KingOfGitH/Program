package zifuchuan;

public class _344反转字符串 {
    public void reverseString(char[] s) {
        int begin=0;
        int end=s.length-1;
        char tmp;
        while (begin<=end){
            tmp=s[begin];
            s[begin++]=s[end];
            s[end++]=tmp;
        }
    }
}
