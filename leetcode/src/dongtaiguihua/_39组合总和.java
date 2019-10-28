package dongtaiguihua;

import java.util.*;

public class _39组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        int length = candidates.length;
        Map<Integer,Set<List<Integer>>> map=new HashMap<>();
        for (int i = 1; i <= target; i++) {
            map.put(i,new HashSet<>());
            for (int j = 0; j < length&& candidates[j]<=target; j++) {
                if (i==target){
                    List<Integer> integers = new ArrayList<>();
                    integers.add(i);
                    map.get(i).add(integers);
                }else if (i>target){
                    int key=i-candidates[j];
                    for (List<Integer> list : map.get(key)) {
                        List<Integer> list1=new ArrayList<>(list);
                        list1.add(candidates[j]);
                        Collections.sort(list1);
                        map.get(i).add(list1);
                    }
                }
            }
        }
        return result;
    }
}
