package cn.edu.leetcode.tencent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 无重复字符的最长子串 {
//    public int lengthOfLongestSubstring(String s) {
//        int ans=0;
//        Set<Character> set=new HashSet<>();
//        int i=0,j=0;
//        int length = s.length();
//        while (i<length&&j<length){
//            if (length-i<=ans) return ans;
//            if (!set.contains(s.charAt(j))){
//                set.add(s.charAt(j++));
//                if (j-i>ans) ans=j-i;
//            }
//            else set.remove(s.charAt(i++));
//        }
//        return ans;
//    }

//    public int lengthOfLongestSubstring(String s) {
//        int ans=0;
//        Map<Character,Integer> map=new HashMap();
//        int i=0,j=0;
//        int length = s.length();
//        while (i<length&&j<length){
//            if(map.get(s.charAt(j))==null||map.get(s.charAt(j))<i){
//                map.put(s.charAt(j),j++);
//                if (j-i>ans) ans=j-i;
//            }else {
//                i=map.get(s.charAt(j))+1;
//                map.put(s.charAt(j),j++);
//            }
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aoaqjabce"));
    }
    public  static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}
