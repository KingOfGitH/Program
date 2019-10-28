package cn.edu.wangyi;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
******************************开始写代码******************************/
    static boolean CheckBlackList(String userIP, String blackIP) {
        String[] split = userIP.split("\\.");
        String[] split1 = blackIP.split("\\.");
        for (int i = 0; i < 3; i++) {
            if (!split[i].equals(split1[i]))return false;
        }
        String[] split2 = split1[3].split("/");
        if (split2.length==1){
            if (!split[3].equals(split1[3]))return false;
        }else {
            if (Integer.parseInt(split2[0])>Integer.parseInt(split[3])||Integer.parseInt(split2[1])<Integer.parseInt(split[3])) return false;
        }
        return true;
    }
/******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean res;
            
        String _userIP;
        try {
            _userIP = in.nextLine();
        } catch (Exception e) {
            _userIP = null;
        }
        
        String _blackIP;
        try {
            _blackIP = in.nextLine();
        } catch (Exception e) {
            _blackIP = null;
        }
  
        res = CheckBlackList(_userIP, _blackIP);
        System.out.println(String.valueOf(res ? 1 : 0));  
    }
}
