package cn.edu.test;

import java.util.*;

import static sun.swing.MenuItemLayoutHelper.max;

public class 特殊排序 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        String[] split = s.split("\\s");
        char res[]=new char[26];
        Map<Character, List<Character>> a=new HashMap<>();
        Map<Character, Integer> b=new HashMap<>();
        for (String s1 : split) {
            for (int i = 0; i < s1.length(); i++) {
                b.put(s1.charAt(i),0);
                a.put(s.charAt(i),new ArrayList<>());
            }
        }
        char c1;
        char c2;
        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < max(split[i].length(),split[i+1].length()); j++) {
                if ((c1=split[i].charAt(j))!=(c2=split[i+1].charAt(j))){
                    if(a.get(c1).add(c2)){
                        b.put(c2,b.get(c2)+1);
                    }
                }
                break;
            }
        }


        scanner.close();
    }
}
