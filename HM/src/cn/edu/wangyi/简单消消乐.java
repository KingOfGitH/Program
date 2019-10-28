package cn.edu.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class 简单消消乐 {
    static int m,n;
    public static void main(String[] args) {
        m=4;
        n=4;
        Scanner scanner=new Scanner(System.in);
        char[][] arr=new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j]=  scanner.next().charAt(0);
            }
        }
        System.out.println(Arrays.deepToString(arr));
        int x1=3,y1=2,x2=3,y2=3;
        System.out.println(swap(arr, x1, y1, x2, y2));
    }

    private static int swap(char[][] arr, int x1, int y1, int x2, int y2) {
        char tmp=arr[x1][y1];
        arr[x1][y1]=arr[x2][y2];
        arr[x2][y2]=tmp;
        return flash(arr,x1,y1)+flash(arr,x2,y2);
    }

    private static int flash(char[][] arr, int x1, int y1) {
        int x=0,y=0;
        if (arr[x1][y1]!='0'){
            for (int i = 0; i <= 2; i++) {
                if (x1+i>=m||arr[x1+i][y1]!=arr[x1][y1]) break;
                x++;
            }
            for (int i = 0; i <= 2; i++) {
                if (y1+i>=n||arr[x1][y1+i]!=arr[x1][y1]) break;
                y++;
            }
            for (int i = -1; i >= -2; i--) {
                if (x1+i<0||arr[x1+i][y1]!=arr[x1][y1]) break;
                x++;
            }
            for (int i = -1; i >= -2; i--) {
                if (y1+i<0||arr[x1][y1+i]!=arr[x1][y1]) break;
                y++;
            }
        }
        if (x>2&&y>2) {
            arr[x1][y1]=0;
            return x+y-1;
        }
        else if (x>2){
            arr[x1][y1]=0;
            return x;
        }
        else if (y>2) {
            arr[x1][y1] = 0;
            return y;
        }else return 0;
    }
}
//0 F 0 E 0 C A C G F A D A A B A
//H F C E G C A C G F A D
// D C B A