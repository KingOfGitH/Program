import java.util.Scanner;
import java.util.Stack;

public class bijicaogao {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        scanner.close();
        char[] chars = s.toCharArray();
        Stack stack=new Stack();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='('){
                stack.push('(');
                while (!stack.isEmpty()&&stack.get(stack.size() - 1).equals('(')){
                    i++;
                    if (chars[i]=='('){
                        stack.push('(');
                    }else if (chars[i]==')'){
                        stack.pop();
                    }
                }
            }else if (chars[i]=='<'&&!stack.isEmpty()){
                stack.pop();
            }else if (chars[i]!='<')stack.push(chars[i]);
        }
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }
    }
}
