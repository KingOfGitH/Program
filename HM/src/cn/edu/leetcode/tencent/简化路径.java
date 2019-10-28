package cn.edu.leetcode.tencent;

import java.util.Arrays;
import java.util.Stack;

public class 简化路径 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/..hidden"));
    }
    public static String simplifyPath(String path) {
        String[] split = path.split("\\/");
        Stack<String> stack=new Stack<>();
        for (int i = 0; i < split.length; i++) {
            if (!stack.isEmpty()&&split[i].equals("..")){
                stack.pop();
            }else if (!split[i].equals("")&&!split[i].equals("..")&&!split[i].equals(".")){
                stack.push(split[i]);
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder stringBuilder=new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append("/"+stack.pop());
        }
        return String.valueOf(stringBuilder);
////        path=path.replaceAll("\\.{3}","\\\\");
//        path=path.replaceAll("\\.{2}","\\\\\\\\");
//        System.out.println(path);
//        path=path.replaceAll("\\.","");
//        path = path.replaceAll("\\/+", "/");
//        String[] split = path.split("\\/");
//
//
//
//        System.out.println(Arrays.toString(split));
//        int tmp=0;
//        for (int i = 0; i < split.length; i++) {
//            if (split[i].trim().equals("\\\\")){
//                split[i]="";
//                tmp=i-1;
//                while (tmp>0){
//                    if (split[tmp].trim().equals("")) tmp--;
//                    else break;
//                }
//                if (tmp>0){
//                    split[tmp]="";
//                }
//            }
//        }
//        StringBuilder stringBuilder=new StringBuilder();
//        for (int i = 0; i < split.length; i++) {
//            if (!split[i].trim().equals("")){
//                if (split[i].trim().equals("\\"))stringBuilder.append("/...");
//                else stringBuilder.append("/"+split[i]);
//            }
//        }
//        path= String.valueOf(stringBuilder);
//        if (path.equals("")) return "/";
//        return path;
    }
}
