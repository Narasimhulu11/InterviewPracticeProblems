package interviews.das.lists;

class Node{
    int data;
    Node next;

    Node(int ndata) {
        data = ndata;
        next = null;
    }
}

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node reverse=getReversedList(head);

        while(reverse!=null){
            System.out.println(reverse.data);
            reverse=reverse.next;
        }
    }

    private static Node getReversedList(Node head) {

        Node prev=null,curr=head,next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
     return prev;
    }


}
