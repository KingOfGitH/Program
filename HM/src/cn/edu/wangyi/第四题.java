package cn.edu.wangyi;

import java.util.*;

public class 第四题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        String tmpSt;
        char[][] chars=new char[m][n];
        scanner.nextLine();
        Map<Character, LinkedList<int[]>> map=new HashMap<>();
        for (int i = 0; i < m; i++) {
            tmpSt=scanner.nextLine();
            for (int j = 0; j < n; j++) {
                chars[i][j]= tmpSt.charAt(j);
                if (map.get(chars[i][j])==null){
                    map.put(chars[i][j], new LinkedList<>(Collections.singleton(new int[]{i, j})));
                }else {
                    map.get(chars[i][j]).add(new int[]{i, j});
                }
            }
        }

        int[][] res=new int[2][2];
        int[] a;
        int[] b;
        int max=0;
        int equ;
        for (List<int[]> value : map.values()) {
            for (int[] i : value) {
                System.out.print(Arrays.toString(i));
            }
            System.out.println();
            int size = value.size();
            for (int i = 0; i < size-1; i++) {
                a = value.get(i);
                for (int j = 1; j < size; j++) {
                    b = value.get(j);
                    equ = isEqual(chars, a[0], a[1], b[0], b[1],m,n);
                    if (equ>max){
                        max=equ;
                        res[0][0]=a[0];
                        res[0][1]=a[1];
                        res[1][0]=b[0];
                        res[1][1]=b[1];
                    }
                }
            }
        }
        if (max==0) System.out.println(max);
        else{
            System.out.println(max);
            System.out.println(res[0][0]+" "+res[0][1]);
            System.out.println(res[1][0]+" "+res[1][1]);
        }



    }

    public static int isEqual(char[][] chars,int a,int b,int c,int d,int m,int n){
        int res=2;
        boolean flag=true;

        while (flag){
            if (a+res>=m||b+res>=n||c+res>=m||d+res>=n){
                flag=false;
                break;
            }else {
                for (int i = 0; i < res; i++) {
                    if (!flag){
                        break;
                    }
                    for (int j = 0; j < res; j++) {
                        if (chars[a+i][b+j]!=chars[c+i][d+j]){
                            flag=false;
                            break;
                        }
                    }
                }
                if (flag) res++;
            }

        }

        return res-1;
    }
}
