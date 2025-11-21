package org.example;

public class DetectLoop {
    public static void main(String args[]){
        Node node = new Node(10);
        node.next=new Node(20);
        node.next.next=new Node(30);
        node.next.next.next=node.next;
        detectLoop(node);
    }

    private static void detectLoop(Node node) {
        Node first=node,second=node;
        while(first!=null && second!=null & second.next!=null){
            if(first==second){
                System.out.println("loop found");
                break;
            }
            first=first.next;
            second=second.next.next;
        }
    }
}
