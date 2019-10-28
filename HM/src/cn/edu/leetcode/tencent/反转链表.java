package cn.edu.leetcode.tencent;

import java.util.*;
public class 反转链表 {

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        ListNode[] lists=new ListNode[3];
        ListNode a=new ListNode(0);
        ListNode b=a;
        for (int i = 0; i < 3; i++) {

        }
        new 反转链表();
        scanner.close();
//        int i=10;
//        while (i / 2 + i % 2!=1 ){
//            i=i / 2 + i % 2;
//            System.out.println(i);
//        }
    }

    /**
     * 合并K个排序链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length / 2 + lists.length % 2 ;
        if (size==1) return lists[0];
        ListNode[] newLists=new ListNode[size];
        for (int i = 0; i < lists.length; i+=2) {
            newLists[i/2]=new 反转链表().mergeTwoLists(lists[i],lists[i+1]);
        }
        if (lists.length % 2==1){
            newLists[size-1]=lists[lists.length-1];
        }
        return mergeKLists(newLists);
    }
    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(0);
        ListNode result=res;
        while (l1!=null||l2!=null){
            if (l1==null){
                res.next=new ListNode(l2.val);
                res=res.next;
            }else if (l2==null){
                res.next=new ListNode(l1.val);
                res=res.next;
            }else {
                if(l1.val>l2.val){
                    res.next=new ListNode(l2.val);
                    res=res.next;
                    l2=l2.next;
                }else {
                    res.next=new ListNode(l1.val);
                    res=res.next;
                    l1=l1.next;
                }
            }
        }
        return result.next;
    }

    /**
     * 两数相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(0);
        ListNode result=res;
        int c=0;
        while (l1!=null&&l2!=null){
            c=l1.val+l2.val+c;
            res.next=new ListNode(c%10);
            res=res.next;
            c=c/10;
            l1=l1.next;
            l2=l2.next;
        }
        if (l1==null){
            while (l2!=null){
                c=l2.val+c;
                res.next=new ListNode(c%10);
                res=res.next;
                c=c/10;
                l2=l2.next;
            }
        }
        if (l2==null){
            while (l1!=null){
                c=l1.val+c;
                res.next=new ListNode(c%10);
                res=res.next;
                c=c/10;
                l1=l1.next;
            }
        }
        if(c!=0){
            res.next=new ListNode(c%10);
            res=res.next;
        }
        return result.next;
    }
    public ListNode reverseList(ListNode head) {
        ListNode listNode =null;
        return new 反转链表().reverseList(head,listNode);
//        ListNode listNode =null;
//        ListNode currNode=head;
//        ListNode tmpNode=null;
//        while (currNode!=null){
//            tmpNode=currNode.next;
//            currNode.next=listNode;
//            listNode=currNode;
//            currNode=tmpNode;
//        }
//        return listNode;
    }
    public ListNode reverseList(ListNode curr,ListNode newNode) {
        if (curr==null)return newNode;
        ListNode tmpNode=curr.next;
        curr.next=newNode;
        newNode=curr;
        return reverseList(tmpNode,newNode);
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
