package cn.edu.leetcode.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class 消除和为零 {

    public static void main(String[] args) {
        int[] list={5,-2,7,6,-7,6,-10,2,0,-1,10,-7,8,7,-8,-2,-10,-2,9,3,0,-1,2,2,-3,7,-7,-9,8,5,0,1,1,-3,-10,-3,6,-7,4,2,8};
        ListNode head=new ListNode(list[0]);
        ListNode res=head;
        for (int i = 1; i < list.length; i++) {
            head.next=new ListNode(list[i]);
            head=head.next;
        }
        head=removeZeroSumSublists(res);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

        public static ListNode removeZeroSumSublists(ListNode head) {
            List<Integer> list=new ArrayList<>();
            while(head!=null){
                list.add(head.val);
                head=head.next;
            }
            boolean flag=true;
            while(flag){
                flag=false;
                int size = list.size();
                int[] sum=new int[size+1];
                for (int i = 0; i < size; i++) {
                    sum[i+1]=sum[i]+list.get(i);
                }
                for (int i = 0; i < size; i++) {
                    for (int j = i+1; j < size+1; j++) {
                        if (sum[j]-sum[i]==0){
                            for (int k = i; k < j; k++) {
                                flag=true;
                                list.set(k,0);
                                sum[k]=sum[i];
                            }
                        }
                    }
                }
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i)==0){
                        list.remove(i);
                        i--;
                    }
                }
            }
            if (list.size()>0){
                head=new ListNode(list.get(0));
                ListNode res=head;
                for (int i = 1; i < list.size(); i++) {
                    head.next=new ListNode(list.get(i));
                    head=head.next;
                }
                return res;
            }
            return null;

        }
}
class Student {
    private int code;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return code == student.code &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }
}

