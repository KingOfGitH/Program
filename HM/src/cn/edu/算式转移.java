package cn.edu;

import java.util.Arrays;
import java.util.Scanner;

public class 算式转移 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] num=new int[n];
        char[] opr=new char[n-1];
        scanner.nextLine();
        String s=scanner.nextLine();
        String[] split = s.split("\\s");
        for (int i = 0; i < split.length-1; i+=2) {
            num[i/2]= Integer.parseInt(split[i]);
            opr[i/2]=split[i+1].trim().charAt(0);
        }
        num[n-1]= Integer.parseInt(split[split.length-1]);
        for (int i = 0; i < n-1; i++) {
            switch (opr[i]){
                case '+':
                    int a=i;
                    while (i<n-2&&opr[i+1]=='+'){
                        i++;
                    }
                    int b=i;
                    if (b<n-2&&(opr[b+1]=='*'||opr[b+1]=='/')){
                        if (a>0&&(opr[a-1]=='*'||opr[a-1]=='/')){
                            sortPart(num,a+1,b);
                        }else {
                            sortPart(num,a,b);
                        }
                    }else if (a>0&&(opr[a-1]=='*'||opr[a-1]=='/')){
                        sortPart(num,a+1,b);
                    }else sortPart(num,a,b+1);
                    break;
                case '*':
                    a=i;
                    while (i<n-2&&opr[i+1]=='*'){
                        i++;
                    }
                    b=i;
                    if (a>0&&opr[a-1]=='/'){
                        sortPart(num,a+1,b+1);
                    }else sortPart(num,a,b+1);
                    break;
                case '/':
                    a=i;
                    while (i<n-2&&opr[i+1]=='/'){
                        i++;
                    }
                    b=i;
                    if (b-a>0){
                        sortPart(num,a+1,b+1);
                    }
                    break;
            }
        }
        for (int i = 0; i < n-1; i++) {
            System.out.print(num[i]+" ");
            System.out.print(opr[i]+" ");
        }
        System.out.println(num[n-1]);

    }
    public static void sortPart(int[] arr,int a,int b){
        if (a>b)return;
        int[] tmp=new int[b-a+1];
        for (int i = a; i <= b; i++) {
            tmp[i-a]=arr[i];
        }
        Arrays.sort(tmp);
        for (int i = a; i <= b; i++) {
            arr[i]=tmp[i-a];
        }
        tmp=null;
    }
}
