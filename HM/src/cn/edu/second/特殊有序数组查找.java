package cn.edu.second;

public class 特殊有序数组查找 {
    public static void main(String[] args) {
        String[] a={"a","","a","a","a","a","a","","","b"};
        String s="a";
        System.out.println(findString(a,s));
    }

    public static int findString(String[] a,String s){
        int begin=0;
        int end=a.length-1;
        int mid=0;
        while (begin<=end){
            mid=begin+((end-begin)>>1);
            while (a[mid].equals("")){
                mid++;
                if (mid>end){
                    mid--;
                    while (a[mid].equals("")){
                        mid--;
                        if (mid<begin){
                            return -1;
                        }
                    }
                }
            }
            if (a[mid].compareTo(s)>0){
                end=mid-1;
            }else if (a[mid].compareTo(s)<0){
                begin=mid+1;
            }else return mid;
        }
        return -1;
    }
}
