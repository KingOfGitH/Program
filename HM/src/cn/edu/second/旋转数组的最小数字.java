package cn.edu.second;


public class 旋转数组的最小数字 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String next = scanner.next();
        int[] a={9,9,9,9,9,9};
        System.out.println(findMinNum(a));

    }

    public static int findMinNum(int[] a){

        int begin=0;
        int end=a.length-1;
        if (a[begin]<a[end]){
            return a[begin];
        }
        while (begin+1<end){
            int mid=begin+((end-begin)>>1);
            if (a[mid]==a[begin] && a[mid]==a[end]){
                return findMin(a);
            }
            if (a[mid]>a[begin]){
                begin=mid;
            }else if (a[mid]<a[begin]){
                end=mid;
            }
        }
        return a[end];
    }
    public static int findMin(int[] a){
        for (int i = 1; i < a.length; i++) {
            if (a[i-1]>a[i]){
                return a[i];
            }
        }
        return a[0];
    }
}
