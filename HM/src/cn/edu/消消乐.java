package cn.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 消消乐 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int arr[][]=new int[4][4];
        int res[][]=new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                switch (N){
                    case 1: arr[3-i][j]=scanner.nextInt();break;
                    case 2: arr[i][j]=scanner.nextInt();break;
                    case 3: arr[3-j][i]=scanner.nextInt();break;
                    case 4: arr[j][3-i]=scanner.nextInt();break;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            List<Integer> list=new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                if (arr[j][i]!=0)
                list.add(arr[j][i]);
            }
            for (int j = 0; j < list.size(); j++) {
                if (j+1>list.size()-1){
                    break;
                }
                if (list.get(j)==list.get(j+1)){
                    list.set(j,list.get(j)<<1);
                    list.set(j+1,0);
                    j++;
                }
            }
            ArrayList<Integer> list1=new ArrayList<>();
            for (Integer integer : list) {
                if (integer!=0){
                    list1.add(integer);
                }
            }

            for (int j = 0; j < 4 - list1.size(); j++) {
                res[j][i]=0;
            }
            for (int j = 4 - list1.size() ; j < 4; j++) {
                res[j][i]=list1.get(j-4+list1.size());
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                switch (N){
                    case 1:
                        if (j == 3) {
                            System.out.print(res[3-i][j]);
                        } else {
                            System.out.print(res[3-i][j]+" ");
                        }
                        break;
                    case 2:
                        if (j == 3) {
                            System.out.print(res[i][j]);
                        } else {
                            System.out.print(res[i][j]+" ");
                        }
                        break;
                    case 3:
                        if (j == 3) {
                            System.out.print(res[3-j][i]);
                        } else {
                            System.out.print(res[3-j][i]+" ");
                        }
                        break;
                    case 4:
                        if (j == 3) {
                            System.out.print(res[j][3-i]);
                        } else {
                            System.out.print(res[j][3-i]+" ");
                        }
                        break;
                }
            }
            System.out.println();
        }
    }
}
