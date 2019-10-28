package zifuchuan;

import java.util.Arrays;

public class _43字符串相乘 {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int length=m+n;
        int res[]=new int[length];
        int index;
        char[] arrM = num1.toCharArray();
        char[] arrN = num2.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                index=length-1-i-j;
                res[index]+=(arrN[n-1-j]-'0')*(arrM[m-1-i]-'0');
            }
        }
        System.out.println(Arrays.toString(res));
        int tmp=0;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i]+=tmp;
            tmp=res[i]/10;
            res[i]=res[i]%10;
        }
        StringBuilder stringBuilder=new StringBuilder(m+n);
        index=0;
        while (res[index]==0){
            index++;
            if (index>=length) return "0";
        }
        for (int i = index; i < length; i++) {
            stringBuilder.append(res[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String multiply = new _43字符串相乘().multiply("123", "456");
        System.out.println(multiply);
    }
}
