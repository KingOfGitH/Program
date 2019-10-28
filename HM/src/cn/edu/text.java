package cn.edu;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Scanner;
import java.util.Stack;

public class text {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        scanner.close();
        if (num==0){
            System.out.println("0");
            return;
        }
        String[] arr=new String[]{"","十","百","千","万","十","百","千","亿","十"};
        StringBuilder res=new StringBuilder();
        int[] ints=new int[12];
        int t=num;
        int i=0;
//        if (num<0) res.append("负");
        while (t!=0){
            ints[i++]=t%10;
            t/=10;
        }
        if (ints[0]!=0) res.append(ints[0]);
        for (int j = 1; j < i; j++) {
            if (ints[j]==0){
                while (j<i&&ints[j++]==0);
                if (res.length()!=0) res.append("0");
                j--;
                res.append(arr[j]+ints[j]);
            }else {
                res.append(arr[j]+ints[j]);
            }

        }
        if (num<0) System.out.print("负");
        System.out.println(res.reverse());
    }

    private static void 找递增下标() {
        Scanner scanner=new Scanner(System.in);
        int len=scanner.nextInt();
        int[] arr=new int[len];
        for (int i = 0; i < len; i++) {
            arr[i]=scanner.nextInt();
        }
        int num=scanner.nextInt();
        scanner.close();
        int a=-1,b=-1;
        for (int i = 0; i < len; i++) {
            if (arr[i]>num) break;
            if (arr[i]==num){
                if (a==-1) {
                    a=i;
                }
                b=i;
            }
        }
        System.out.println(a+" "+b);
    }

    private static void 括号匹配() {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        scanner.close();
        Stack stack=new Stack();
        int len = str.length();
        char c;
        for (int i = 0; i < len; i++) {
            c = str.charAt(i);
            if (c=='('||c=='['||c=='{'||c=='<'){
                stack.push(c);
            }else if (c==')'||c==']'||c=='}'||c=='>'){
                if (stack.isEmpty()){
                    System.out.println(0);
                    return;
                }else {
                    char a = (char) stack.pop();
                    if (c==')'&&a=='(')continue;
                    if (c==']'&&a=='[')continue;
                    if (c=='}'&&a=='{')continue;
                    if (c=='>'&&a=='<')continue;
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(1);
    }

    private static void 匹配目标和() {
        Scanner scanner=new Scanner(System.in);
        int len=scanner.nextInt();
        int[] arr=new int[len];
        for (int i = 0; i < len; i++) {
            arr[i]=scanner.nextInt();
        }
        int sum=scanner.nextInt();
        scanner.close();

        int a=-1,b=-1;
        int tmp;
        for (int i = 0; i < len; i++) {
            tmp=sum-arr[i];
            for (int j = i+1; j < len; j++) {
                if (tmp==arr[j]) {
                    a=i;b=j;
                    break;
                }
            }
            if (a!=-1) break;
        }
        System.out.println(a+" "+b);
    }

}
