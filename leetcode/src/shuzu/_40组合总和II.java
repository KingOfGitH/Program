package shuzu;

import java.util.*;

public class _40组合总和II {
    public List<List<Integer>> combinationSum21(int[] candidates, int target) {
        Set<List<Integer>> lists=new HashSet<>();
        Arrays.sort(candidates);
        int length = candidates.length;
        int n= length;
        for (int i = 1; i < length; i++) {
            if (candidates[0]+candidates[i]>=target){
                n=i;
            }
        }
        if (n==length-1) n=length;
        n= (int) Math.pow(2,n);
        System.out.println(n);
        int sum;
        List<Integer> list;
        for (int i = 1; i < n; i++) {
            list=new ArrayList<>();
            sum=0;
            for (int j = 0; j < length; j++) {
                if (((i>>j)&1)==1){
                    list.add(candidates[j]);
                    sum+=candidates[j];

                    if (sum==target){
                        Collections.sort(list);
                        lists.add(list);
                        break;
                    }
                }
            }
        }
        return new ArrayList<>(lists);
    }
    public void dfs(int[] candidates, int cur,int target,List<Integer> list,Set<List<Integer>> lists) {
        if (target==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        if (target<0|| cur==candidates.length) {
            return;
        }

        list.add(candidates[cur]);
        int size = list.size();
        dfs(candidates,cur+1,target-candidates[cur],list,lists);
        list.remove(size-1);
        dfs(candidates,cur+1,target,list,lists);
    }


    private void findCombinationSum2(int[] candidates, int begin, int len, int residue, Stack<Integer> stack, List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 为了避免将负数传递到下一个分支，这里剪枝
            if (residue - candidates[i] < 0) {
                break;
            }

            // 相同部分剪枝
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            stack.add(candidates[i]);
            findCombinationSum2(candidates, i + 1, len, residue - candidates[i], stack, res);
            stack.pop();
        }
    }


    public static void main(String[] args) {
        System.out.println(new _40组合总和II().combinationSum2(
//                new int[]{10,1,2,7,6,1,5},8));
                new int[]{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12}, 27));
    }


//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        int len = candidates.length;
//        List<List<Integer>> res = new ArrayList<>();
//        if (len == 0) {
//            return res;
//        }
//        // 先将数组排序，这一步很关键
//        Arrays.sort(candidates);
//        findCombinationSum2(candidates, 0, len, target, new Stack<>(), res);
//        return res;
//    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> lists=new HashSet<>();
        Arrays.sort(candidates);
        dfs(candidates,0,target,new ArrayList<>(),lists);
        return new ArrayList<>(lists);
    }

}
//5 10
//mklghiegbt
//jtegkltjzf
//qhmkljkmhq
//fzjtebgetj
//moqhmlglkm
