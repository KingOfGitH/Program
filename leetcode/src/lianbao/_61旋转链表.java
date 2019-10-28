package lianbao;

public class _61旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int length=0;
        ListNode pre=new ListNode(0);
        ListNode res=pre;
        ListNode curr=head;
        while (head!=null){
            length++;
            head=head.next;
        }


        k=k%length;
        head=curr;
        while (k++<length){
            pre.next=new ListNode(head.val);
            head=head.next;
            pre=pre.next;
        }
        if (head==null) return res.next;
        curr=head;
        while(head.next!=null){
            head=head.next;
        }
        head.next=res.next;
        return curr;
    }
}
