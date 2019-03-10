package cn.dhu.search;
//二分查找，找到返回下标，找不到返回-1
public class ErFenSearch {
    public static void main(String[] args) {
        int[] num={1,2,3,4,5,6,7,8,9};
        int index =erfenSearch(num,3);
        System.out.println(index);
    }
    public static int erfenSearch(int[] num, int key)
    {
        int begin=0;
        int end=num.length;
        while (begin<end){
            int middle =(begin+end)/2;
            if (num[middle]>key){
                end=middle-1;
            }else if (num[middle]<key){
                begin=middle+1;
            }else return middle;
        }
        return -1;
    }
}
