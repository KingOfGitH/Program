package erchashu;

import java.util.*;

public class _39组合总和 {
    public List<List<Integer>> combinationSum(int[] prices, int budget) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Set<List<Integer>>> map = new HashMap<>();
        //对candidates数组进行排序
        Arrays.sort(prices);
        int len = prices.length;
        for(int i = 1;i <= budget;i++){
            //初始化map
            map.put(i,new HashSet<>());
            //对candidates数组进行循环
            for(int j = 0;j < len&&prices[j] <= budget;j++){
                if(i == prices[j]){
                    //相等即为相减为0的情况，直接加入set集合即可
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    map.get(i).add(temp);
                }else if(i > prices[j]){
                    //i-candidates[j]是map的key
                    int key = i-prices[j];
                    //使用迭代器对对应key的set集合进行遍历
                    //如果candidates数组不包含这个key值，对应的set集合会为空，故这里不需要做单独判断
                    for (List<Integer> integers : map.get(key)) {
                        //set集合里面的每一个list都要加入candidates[j]，然后放入到以i为key的集合中
                        List tempList = new ArrayList<>(integers);
                        tempList.add(prices[j]);
                        //排序是为了通过set集合去重
                        Collections.sort(tempList);
                        map.get(i).add(tempList);
                    }
                }
            }
        }
        if (map.size()>0) result.addAll(map.get(budget));
        if (result.size()<=0) return null;
        int minSize=Integer.MAX_VALUE;
        for (List<Integer> list : result) {
            if (list.size()<minSize) minSize=list.size();
        }
        return result;
    }
}
