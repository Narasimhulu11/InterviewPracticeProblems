package org.example;

import java.util.HashSet;
import java.util.Set;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next=null;
    }
}
public class Interscetion {
    public static void main(String args[]){
        Node head1= new Node(10);
        head1.next=new Node(20);
        head1.next.next = new Node(30);

        Node head2 = new Node(50);
        head2.next = new Node(40);
        head2.next.next = new Node(60);

        head2.next.next.next=head1.next;
        findintersec(head1,head2);
    }

    private static void findintersec(Node head1, Node head2) {
        Set<Node> set = new HashSet<>();
        Node temp=head1;
        while(temp!=null){
            set.add(temp);
            temp=temp.next;
        }
        Node curr=head2;
        while(curr!=null){
            if(set.contains(curr)){
                System.out.print(curr.data+"->");
                break;
            }
            curr=curr.next;
        }
    }

}
