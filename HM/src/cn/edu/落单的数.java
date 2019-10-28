package cn.edu;

import java.util.*;

public class 落单的数 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        scanner.close();
        try {
            String[] split = s.split("\\s");
            int length = split.length;
            int[] nums=new int[length];
            for (int i = 0; i < length; i++) {
                nums[i]= Integer.parseInt(split[i]);
            }
            System.out.println(length);
            System.out.println(Arrays.toString(nums));
            int res=0;
            if (length>0) res=nums[0];
            int sum=0;
            for (int i = 0; i < length; i++) {
                if (sum>0) sum+=nums[i];
                else sum=nums[i];
                res=Math.max(sum,res);
            }
            System.out.println(res);
        } catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }

//        Scanner scanner=new Scanner(System.in);
//        String s=scanner.nextLine();
//        scanner.close();
//        String[] split = s.split(";");
//        if (split[0].length()!=split[1].length()) {
//            System.out.println("False");
//            return;
//        }
//        int n=split[0].length();
//        char[] ch1 = split[0].toCharArray();
//        char[] ch2 = split[1].toCharArray();
//        HashMap<Character,Character> map=new HashMap<>();
//        int res=ch1[0]-ch2[0];
//        for (int i = 0; i < n; i++) {
//            if (map.containsKey(ch1[i])&&map.get(ch1[i])==ch2[i]){
//            }else if (!map.containsKey(ch1[i])&&!map.containsValue(ch2[i])){
//                map.put(ch1[i],ch2[i]);
//            }else {
//                System.out.println("False");
//                return;
//            }
//        }
//        System.out.println("True");
    }
}
