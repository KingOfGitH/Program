package lianbao;

public class _160相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null) return null;
        ListNode tmpA=headA,tmpB=headB;
        int lengthA=0,lengthB=0;
        while (tmpA!=null){
            lengthA++;
            tmpA=tmpA.next;
        }
        while (tmpB!=null){
            lengthB++;
            tmpB=tmpB.next;
        }
        if (lengthA>lengthB){
            int tmp=lengthA;
            lengthA=lengthB;
            lengthB=tmp;
            tmpA=headB;
            tmpB=headA;
        }else {
            tmpA=headA;
            tmpB=headB;
        }

        while (lengthA<lengthB){
            lengthB--;
            tmpB=tmpB.next;
        }
        while (tmpA!=null){
            if (tmpA==tmpB){
                return tmpA;
            }
            tmpA=tmpA.next;
            tmpB=tmpB.next;
        }
        return null;
    }
}
