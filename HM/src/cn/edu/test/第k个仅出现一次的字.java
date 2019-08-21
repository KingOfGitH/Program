package cn.edu.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 第k个仅出现一次的字 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<String > strings = new ArrayList<>();
        int N=0;
        String s=null;

        while(scanner.hasNextLine()){
            s = scanner.nextLine();
            if (s.equals(""))break;
            String s1 = s.split("\\s")[0];
            N = Integer.parseInt(s1);
            strings.add(基数排序(N, s.substring(s1.length()+1)));
        }

        strings.forEach(s1 -> {
            if(s1.equals("Myon~")) System.out.println("Myon~");
            else System.out.println("["+s1+"]");
        });

    }

    private static String 基数排序(int n, String s) {
        int[] arr=new int[128];
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)]==1){
                count++;
                if (count==n) return String.valueOf(s.charAt(i));
            }
        }
        if (count<n||n<=0) return "Myon~";
        else return null;
    }
}



