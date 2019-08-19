package cn.edu.test;

import java.util.*;

public class 数组中n个数和等于N {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=10;
        int[] a ={2,3,5};
        List<List<Integer>> lists = new 数组中n个数和等于N().combinationSum(a, n);
        System.out.println(lists);
        String s="";
        if (s==null|| "".equals(s))
        System.out.println(s.split("\\s").length);
//        String s=scanner.nextLine();
//        System.out.println(s);
//        String[] split = s.split("\\s");
//        n= Integer.parseInt(split[0]);
//        System.out.println(n);
//        String substring = split[1].substring(1, split[1].length() - 1);
//        String[] split1 = substring.split(",");
//        System.out.println(substring);
//        for(int i=0;i<a.length;i++){
//            a[i]=Integer.parseInt(split1[i]);
//        }
//        System.out.println(Arrays.toString(a));
//        Arrays.sort(a);
//        int[] b=new int[a.length];
//        int j=0;
//
//        for (int i = 0; i < a.length-1; i++) {
//            b[j]=a[i];
//            while (i+1 < a.length-1&&b[j]==a[i+1]){
//                i++;
//            }
//            j++;
//        }
//        System.out.println(find(b,n,j-1));
    }

    private static int find(int[] a, int n, int m){
        int count=0;
        if (m<0) return 0;
        int tmp=n/a[m];
        if (tmp<=0) return 0;
        for (int i = 0; i <= tmp; i++) {
            if (n==a[m]*i) {
                count++;
                break;
            }
            count+=find(a,n-a[m]*i,m-1);
        }
        return count;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Set<List<Integer>>> map = new HashMap<>();
        //对candidates数组进行排序
        Arrays.sort(candidates);
        int len = candidates.length;
        for(int i = 1;i < target;i++){
            int tmp=candidates[i];
            if (tmp>target) break;
            //初始化map
            map.computeIfAbsent(tmp, k -> new HashSet<>());
            //对candidates数组进行循环
            for(int j = 0;j < len&&candidates[j] <= target;j++){
                if(tmp == candidates[j]){
                    //相等即为相减为0的情况，直接加入set集合即可
                    List<Integer> temp = new ArrayList<>();
                    temp.add(tmp);
                    map.get(tmp).add(temp);
                }else if(tmp > candidates[j]){
                    //i-candidates[j]是map的key
                    int key = tmp-candidates[j];
                    //使用迭代器对对应key的set集合进行遍历
                    //如果candidates数组不包含这个key值，对应的set集合会为空，故这里不需要做单独判断
                    if (map.get(key)!=null){
                        for (List<Integer> integers : map.get(key)) {
                            //set集合里面的每一个list都要加入candidates[j]，然后放入到以i为key的集合中
                            List tempList = new ArrayList<>(integers);
                            tempList.add(candidates[j]);
                            //排序是为了通过set集合去重
                            Collections.sort(tempList);
                            map.get(tmp).add(tempList);
                        }
                    }

                }
            }
        }


        if (map.size()>0) result.addAll(map.get(target));
        return result;
    }

}
