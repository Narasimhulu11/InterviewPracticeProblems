package interviews.das.lists;

public class MergetwoSortedLists {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(6);
        head1.next.next.next = new ListNode(8);
        head1.next.next.next.next = new ListNode(10);
        ListNode merged=mergeTwoLists(head,head1);
        while (merged!=null){
            System.out.println(merged.val);
            merged=merged.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if(list1==null){
        return list2;
    }
    if(list2==null){
        return list1;
    }
    if(list1.val<=list2.val){
        list1.next=mergeTwoLists(list1.next,list2);
        return list1;
    }else{
        list2.next=mergeTwoLists(list1,list2.next);
        return list2;
    }

    }
}
