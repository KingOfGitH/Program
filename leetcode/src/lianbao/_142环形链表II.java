package lianbao;

public class _142环形链表II {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                fast=head;
                while (fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
