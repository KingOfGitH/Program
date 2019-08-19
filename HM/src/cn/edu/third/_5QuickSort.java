package cn.edu.third;

import java.util.Arrays;

public class _5QuickSort {
    public static void main(String[] args) {
        int[] a={2, 1,4,5,3,6,9,2,1,0};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    static void quickSort(int[] A,int p,int r){
        if (p<r){
            int q=huaFenThreeMid(A,p,r);
            quickSort(A,p,q-1);
            quickSort(A,q+1,r);
        }
    }
//    static void quickSort(int[] A,int p,int r){
//        if (p<r){
//            int[] q = huaFenThree(A, p, r);
//            quickSort(A,p,q[0]-1);
//            quickSort(A,q[1]+1,r);
//        }
//    }

    /**
     * 单指针
     * @param A
     * @param p
     * @param r
     * @return
     */
    private static int huaFenSingle(int[] A, int p, int r) {
        int flag=A[p];
        int sp=p+1;
        int end=r;
        while (sp<=end){
            if(A[sp]<=flag) sp++;
            else {
                swap(A,sp,end);
                end--;
            }
        }
        swap(A, p, end);
        return end;
    }

    /**
     * 双向扫描
     * @param A
     * @param p
     * @param r
     * @return
     */
    private static int huaFenDouble(int[] A, int p, int r) {
        int flag=A[p];
        int sp=p+1;
        int end=r;
        while (sp<=end){
            while (sp<=end&&A[sp]<=flag) sp++;
            while (sp<=end&&A[end]>flag) end--;
            if (sp<=end){
                swap(A,sp,end);
            }
        }
        swap(A, p, end);
        return end;
    }

    /**
     * 三指针法，用于大量数据相等
     * @param A
     * @param p
     * @param r
     * @return
     */
    private static int[] huaFenThree(int[] A, int p, int r) {
        int flag=A[p];
        int sp=p+1;
        int eql=sp;
        int end=r;
        while (sp<=end){
            if(A[sp]<=flag) {
                if (A[sp]<flag){
                    if (sp==eql){
                        sp++;
                        eql++;
                    }else {
                        swap(A,sp,eql);
                        sp++;
                    }
                }else sp++;
            } else {
                swap(A,sp,end);
                end--;
            }
        }
        swap(A, p, end);
        return new int[]{eql,end};
    }

    /**
     * 三点中值法
     * @param A
     * @param p
     * @param r
     * @return
     */
    private static int huaFenThreeMid(int[] A, int p, int r) {
        int mid=p+((r-p)>>1);
        if (A[p]>=A[mid]&&A[p]<=A[r] ||A[p]>=A[r]&&A[p]<=A[mid]) mid=p;
        else if (A[r]>=A[mid]&&A[r]<=A[p] ||A[r]>=A[p]&&A[r]<=A[mid]) mid=r;
        swap(A,p,mid);
        return huaFenDouble(A, p, r);
    }

    /**
     * 交换数组两个值
     * @param A
     * @param p
     * @param end
     */
    private static void swap(int[] A, int p, int end) {
        if (A[p]==A[end])return;
        A[end]=A[end]^A[p];
        A[p]=A[end]^A[p];
        A[end]=A[end]^A[p];
    }
}
