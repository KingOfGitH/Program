package cn.edu.leetcode.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 优先有序的偶数topN {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        scanner.close();
        String[] split = s.split(";");
        String[] split1 = split[0].split(",");
        int[] nums=new int[split1.length];
        for (int i = 0; i < split1.length; i++) {
            nums[i]= Integer.parseInt(split1[i]);
        }
        int n=Integer.parseInt(split[1]);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%2==0){
                
            }
        }
        int num=0;
        List<String> stringList=new ArrayList<>();
        List<Integer> intList=new ArrayList<>();

    }
}
