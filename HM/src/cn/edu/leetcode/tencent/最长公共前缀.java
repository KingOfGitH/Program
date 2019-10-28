package cn.edu.leetcode.tencent;

public class 最长公共前缀 {
    public static String find(String s1,String s2){
        int n=Math.min(s1.length(),s2.length());
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i)==s2.charAt(i)){
                stringBuilder.append(s1.charAt(i));
            }else {
                break;
            }
        }
        if (stringBuilder==null)return "";
        else return String.valueOf(stringBuilder);
    }

    public static void main(String[] args) {
        String[] strs=new String[]{"flower","flow","flight"};
        int length = strs.length;
        String res;
        if (length<=0){
//            return "";
            return;
        }else {
            res=strs[0];
        }

        for (int i = 1; i < length ; i++) {
            res=find(res,strs[i]);
        }
        System.out.println(res);
    }
}
