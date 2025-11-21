package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkList {
    Node head=null;
    Node tail=null;
    Node intersection;
    static class Node {
        Node next;
        int data;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    void printIntersectionlist(LinkList list, LinkList list2) {
        Map<Integer,Integer> map = new HashMap<>();
        Node temp = list.head;
        while(temp!=null){
            if(!map.containsKey(temp.data))
                map.put(temp.data, 1);
            else
                map.put(temp.data, map.get(temp.data)+1);
            temp=temp.next;
        }
        System.out.println();
        Node curr=list2.head;
        while(curr!=null){
            if(map.containsKey(curr.data)){
                System.out.print(curr.data+"->");
            }
            curr=curr.next;
        }

      //  print();
    }
    void add(int data){
        Node temp = new Node(data);
        if(head == null){
            head = temp;
            tail = temp;
        }else{
            tail.next = temp;
            tail = temp;
        }
    }
    public static void main(String args[]){
        LinkList list = new LinkList();
        list.add(10);
        list.add(20);
        list.add(30);
       // list.print();
        LinkList list2 = new LinkList();
        list2.add(40);
        list2.add(20);
        list2.add(10);
       // System.out.println();
        //list2.print();
       list.printIntersectionlist(list,list2);

        //list.reverse();
        //list.print();
    }

    private void reverse() {
        Node prev=null;
        Node curr=head;
        Node next=null;
        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    private void print() {
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
    }
}
