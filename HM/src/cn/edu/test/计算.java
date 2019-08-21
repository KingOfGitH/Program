package cn.edu.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 计算 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<Integer> stringRes = new ArrayList<>();
        String s=null;

        while(!scanner.hasNext("END")){
            s = scanner.next();
            int res=result(s);
            stringRes.add(res);
        }
        for (Integer stringRe : stringRes) {
            System.out.println(stringRe);
        }
    }

    private static int result(String s) {
        ArrayList<Integer> stringNum = new ArrayList<>();
        ArrayList<Character> stringOp = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                StringBuffer stringBuffer=new StringBuffer();
                while (i < s.length()&&s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    stringBuffer.append(s.charAt(i));
                    i++;
                }
                i--;
                stringNum.add(Integer.parseInt(String.valueOf(stringBuffer)));
            }else{
                stringOp.add(s.charAt(i));
            }
        }
        for (int i = 0; i < stringOp.size(); i++) {
            if (stringOp.get(i)=='*'){
                int tmp=stringNum.get(i)*stringNum.get(i+1);
                stringNum.set(i,tmp);
                stringNum.remove(i+1);
                stringOp.remove(i--);
            }
        }
        for (int i = 0; i < stringOp.size(); i++) {
            if (stringOp.get(i)=='+'){
                int tmp=stringNum.get(i)+stringNum.get(i+1);
                stringNum.set(i,tmp);
                stringNum.remove(i+1);
                stringOp.remove(i--);
            }else {
                int tmp=stringNum.get(i)-stringNum.get(i+1);
                stringNum.set(i,tmp);
                stringNum.remove(i+1);
                stringOp.remove(i--);
            }
        }
        return stringNum.get(0);
    }
}
