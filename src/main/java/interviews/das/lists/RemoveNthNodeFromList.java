package interviews.das.lists;

import org.test.List;

import java.util.Arrays;

public class RemoveNthNodeFromList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next=head.next;
        ListNode merged=deleteNthNodeFromList(head,3);
        while (merged!=null){
            System.out.println(merged.val);
            merged=merged.next;
        }
    }
    public static ListNode deleteNthNodeFromList(ListNode head, int n) {
        ListNode fast=head;
        ListNode slow=head;

        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        if(fast==null)
            return head.next;
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
      slow.next=slow.next.next;
       return head;
    }
}
