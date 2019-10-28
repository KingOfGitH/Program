package lianbao;

import java.util.Scanner;

public class Solution {
    public void removeDuplicates(ListNode head) {
        // 在这里编写代码
        if (head==null) return;
        int cur=head.val;
        int q=1;
        ListNode res=head;
        ListNode tmp;
        while (res.next!=null){
            if (cur!=res.next.val){
                res=res.next;
                cur=res.val;
                q=1;
            }else if (q<2){
                q++;

                res=res.next;
            }else {
                tmp=res;
                while (res.next!=null&&cur==res.next.val){
                    res=res.next;
                }
                tmp.next=res.next;
            }
        }
        while (head!=null){
            System.out.print(head.val);
            head=head.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        ListNode head=new ListNode(0);
        ListNode res=head;
        for (int i = 0; i < n; i++) {
            res.next=new ListNode(scanner.nextInt());
            res=res.next;
        }
//        res=head;
        new Solution().removeDuplicates(head.next);

    }
}