package cn.edu;


public class 特殊分组身高 {
    public static void main(String[] args) {
        int N=4;
        int[] arr={1,1,1,1};
        if (arr.length==1) {
            System.out.println(1);
            return;
        }
        if (arr.length<1) {
            System.out.println(0);
            return;
        }
        int e=N-1;
        int count=0;
        while (e>=0){
            count++;
//            if (e<=0){
//                System.out.println(count);
//                return;
//            }
            int max=-1;
            int index=e;
            for (int i = 0; i <= e; i++) {
                if (arr[i]>=max){
                    max=arr[i];
                    index=i;
                }
            }
            int min=max;
            boolean flag=true;
            while (flag){
                flag=false;
                for (int i = index; i <= e; i++) {
                    if (arr[i]<min){
                        min=arr[i];
                    }
                }
                for (int i = 0; i < index; i++) {
                    if (arr[i]>min){
                        index=i;
                        flag=true;
                    }
                }
            }
            e=index-1;
        }
//        int i = find(arr, N - 1, 0);
        System.out.println(count);

    }
    public static int find(int[] arr,int e,int count){
        if (arr.length==1) return 1;
        if (arr.length<1) return 0;
        count++;
        if (e<=0)return count;
        int max=-1;
        int index=e;
        for (int i = 0; i <= e; i++) {
            if (arr[i]>=max){
                max=arr[i];
                index=i;
            }
        }
        int min=max;
        boolean flag=true;
        while (flag){
            flag=false;
            for (int i = index; i <= e; i++) {
                if (arr[i]<min){
                    min=arr[i];
                }
            }
            for (int i = 0; i < index; i++) {
                if (arr[i]>min){
                    index=i;
                    flag=true;
                }
            }
        }
        return find(arr,index-1,count);
    }
}
