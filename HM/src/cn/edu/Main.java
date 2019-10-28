package cn.edu;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int DynamicPathPlanning(int[][] matrixGrid) {
        int m = matrixGrid.length;
        int n = matrixGrid[0].length;
        int[][] ints = new int[m][n];
        if (matrixGrid[0][0]==1) return 0;
        else ints[0][0]=1;
        for (int i = 1; i < m; i++) {
            if (matrixGrid[i][0]==1) ints[i][0]=0;
            else ints[i][0]=ints[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            if (matrixGrid[0][i]==1) ints[0][i]=0;
            else ints[0][i]=ints[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrixGrid[i][j]==1) ints[i][j]=0;
                else ints[i][j]=ints[i-1][j]+ints[i][j-1];
            }
        }
        return ints[m-1][n-1];
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _matrixGrid_rows = 0;
        int _matrixGrid_cols = 0;
        _matrixGrid_rows = Integer.parseInt(in.nextLine().trim());
        _matrixGrid_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _matrixGrid = new int[_matrixGrid_rows][_matrixGrid_cols];
        for(int _matrixGrid_i=0; _matrixGrid_i<_matrixGrid_rows; _matrixGrid_i++) {
            for(int _matrixGrid_j=0; _matrixGrid_j<_matrixGrid_cols; _matrixGrid_j++) {
                _matrixGrid[_matrixGrid_i][_matrixGrid_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = DynamicPathPlanning(_matrixGrid);
        System.out.println(String.valueOf(res));

    }
}
