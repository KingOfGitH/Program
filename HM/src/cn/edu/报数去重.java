package cn.edu;

import java.util.HashMap;
import java.util.Scanner;

public class 报数去重 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[] arr=new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i]=scanner.nextInt();
            if (map.get(arr[i])==null){
                map.put(arr[i],1);
            }else {
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (map.get(arr[i])<=m){
                System.out.print(arr[i]+" ");
            }
        }
        scanner.close();
    }
}
