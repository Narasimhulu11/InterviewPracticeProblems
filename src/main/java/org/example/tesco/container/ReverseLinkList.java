package org.example.tesco.container;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLinkList {
    static Node head;

    public static void main(String args[]) {
        Node node = new Node(10);
        head = node;
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        //head.next.next.next.next = head.next.next;
        ReverseLinkList reverseLinkList = new ReverseLinkList();
       // reverseLinkList.print();
        //reverseLinkList.reverse();
        System.out.println(reverseLinkList.detectCycle());

    }

    private boolean detectCycle() {
        Node first=head,second=head;
        while(first!=null && second!=null && second.next!=null){
            first=first.next;
            second=second.next.next;
            if(first==second){
                System.out.println("loop found");
                return true;
            }
        }
        return false;
    }

    private void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
    }

    private void reverse(){
        Node curr=head,prev=null,next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        curr=head;
        System.out.println();
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
    }
}
