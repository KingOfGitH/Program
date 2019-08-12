package cn.edu.second;


public class YT找最大小团体 {
    public static void main(String[] args) {
        String s="YYYYTTTTT";//输入内容

        int[] a = new int[s.length()+1];//辅助空间
        a[0]=0;//初始化a[0]必须为0
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='Y'){
                a[i+1]=a[i]+1;
            }else if (s.charAt(i)=='T'){
                a[i+1]=a[i]-1;
            }
        }
        int maxFlag=0;//记录最大值
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[j]==a[i]){
                    if ((j-i)>maxFlag){
                        maxFlag=j-i;
                    }
                }
            }
        }

        System.out.println(maxFlag);
    }
}
