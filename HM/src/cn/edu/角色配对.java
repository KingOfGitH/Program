package cn.edu;

import java.util.*;

public class 角色配对 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int c=scanner.nextInt();
        int t;

        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < c; i++) {
            t=scanner.nextInt();
            List<Integer> input=new ArrayList<>();
            for (int j = 0; j < t; j++) {
                int nextInt = scanner.nextInt();
                input.add(nextInt);
            }
            list.add(find(input,0));
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
        scanner.close();
    }

    public static int find(List<Integer> list,int count){
        while (list.size()>2){
            int t;
            Collections.sort(list);
            while (list.size()>2&&list.get(0)<=0) list.remove(0);
            if (list.size()<3) return count;
            t=list.size();
            list.set(t-1,list.get(t-1)- 1);
            list.set(t-2,list.get(t-2)- 1);
            list.set(t-3,list.get(t-3)- 1);
            count++;
        }
        return count;
    }

}
