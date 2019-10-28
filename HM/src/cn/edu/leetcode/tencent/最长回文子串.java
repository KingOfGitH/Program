package cn.edu.leetcode.tencent;

import java.util.Arrays;

public class 最长回文子串 {
    public static void main(String[] args) {
        int[] abcbas = find("");
        System.out.println(Arrays.toString(abcbas));
    }
    public static int[] find(String s){
        int[] ints = new int[2];
        int j,k;
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            j=i-1;
            k=i+1;
            while (j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k)){
                if (k-j+1>max){
                    max=k-j+1;
                    ints[0]=j;
                    ints[1]=k;
                }
                j--;
                k++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            j=i;
            k=i+1;
            while (j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k)){
                if (k-j+1>max){
                    max=k-j+1;
                    ints[0]=j;
                    ints[1]=k;
                }
                j--;
                k++;
            }
        }
//        System.out.println(s.substring(ints[0], ints[1]+1));
        return ints;
    }
}
