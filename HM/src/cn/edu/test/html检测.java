package cn.edu.test;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class html检测 {
    public static int main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=null;
        while (scanner.hasNextLine()) {
            s = scanner.nextLine();
        }
        if (s==null||s.length()<=0) return 0;
        scanner.close();
        boolean flag,tag=true,pro=true;
        Stack<StringBuffer> stack=new Stack<>();
        s=s.replaceAll("\\s+"," ");

        for (int i = 0; i < s.length(); i++) {
            if (tag&&pro){
                while (i<s.length()&&s.charAt(i)>='a'&&s.charAt(i)<='z'){
                    i++;
                }
            }
            if (i>=s.length())break;
            if (s.charAt(i)=='<') {
                if (tag){
                    tag=false;
                }
                else return 1;
                i++;
                if (i>=s.length()||s.charAt(i)<'a'||s.charAt(i)>'z') return 1;
                StringBuffer stringBuffer=new StringBuffer();
                while (i<s.length()&&s.charAt(i)>='a'&&s.charAt(i)<='z'){
                    stringBuffer.append(s.charAt(i));
                    i++;
                }
                stack.push(stringBuffer);
            }
            if (i>=s.length())break;
            if (s.charAt(i)=='>') {
                if (tag) return 1;
                else {
                    tag=true;
                    continue;
                }
            }

            if (s.charAt(i)=='=') {
                i++;
                if (i>=s.length()||s.charAt(i)!='"') return 1;
                i++;
                if (i>=s.length()||s.charAt(i)=='"') return 1;
                while (i<s.length()&&s.charAt(i)!='"'){
                    i++;
                }
                if (i>=s.length()||s.charAt(i)!='"') return 1;
                i++;
                if (s.charAt(i)==' '||s.charAt(i)=='>'||s.charAt(i)=='/')
                    i--;
            }

                if (s.charAt(i)=='>')tag=false;
                if (s.charAt(i)==' '){
                    i++;
                    while (s.charAt(i)==' ')i++;
                }

            }

        return 0;
    }
}
