package lianbao;

public class _21合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res=head;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                head.next=l1;
                head=head.next;
                l1=l1.next;
            }else {
                head.next=l2;
                head=head.next;
                l2=l2.next;
            }
        }
        if (l2!=null) head.next=l2;
        if (l1!=null) head.next=l1;

        return res.next;
    }
}