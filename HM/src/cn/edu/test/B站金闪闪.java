package cn.edu.test;

import java.util.Arrays;
import java.util.Scanner;

public class B站金闪闪 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=scanner.nextInt();
        }
        int m=scanner.nextInt();
        int[][] arrB=new int[m][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                arrB[i][j]=scanner.nextInt();
            }
        }
        int[] arrA=new int[n];
        int[] arrC=arr.clone();
        boolean flag;
        for (int i = 0; i < n - 2; i++) {
            flag=true;
            arrA=arr.clone();
            for (int j = i+2; j < n; j++) {
                if (!flag){
                    break;
                }
                sort(arrA,i,j);
                for (int k = i; k <= j-2; k++) {
                    if (arrA[k]+arrA[k+1]>arrA[k+2]){
                        flag=false;
                        arrC[i]=j;
                        break;
                    }
                }
            }
        }
        arrC[n-2]=n+1;
        arrC[n-1]=n+1;
        System.out.println(Arrays.toString(arrC));
        System.out.println(Arrays.toString(arr));
        int count=0;
        for (int i = 0; i < m; i++) {
            if (arrC[arrB[i][0]-1]<=(arrB[i][1]-1)){
                count++;
            }
        }
        System.out.println(count);

    }
    public static void sort(int[] arr, int low, int high) {
        for (int j = low + 1; j <= high; j++) {
            int key = arr[j];
            int pre = j - 1;
            /*套路：大的元素往后移直到前方没有大的，这时插入待排元素*/
            while (pre >= low && arr[pre] > key) {
                arr[pre + 1] = arr[pre];
                pre--;
            }
            arr[pre + 1] = key;
        }
    }
}
