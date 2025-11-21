package org.test;

//browser forward and backward mechanism
//design a browser history mechanism
//when open a new website
//visitng a url
//going back
// going forward

import java.util.LinkedList;

public class List {
 public static void main(String args[]){
     LinkedList<Integer> list = new LinkedList<>();
     //list.addAll(Arrays.asList(1,2,3));
     visit(list);
     goBack(list , 2);
     goForwar(list, 2);
 }

    private static void goForwar(LinkedList<Integer> orgList, int curr) {
        System.out.println(orgList.get(curr+1));
    }

    private static void goBack(LinkedList<Integer> orgList, int curr) {
     if(orgList.size()>2 || curr!=orgList.getFirst()){
         System.out.println(orgList.get(curr-1));
     }else{
         System.out.println("sorry no back history for curr page");
     }
    }

    private static void visit(LinkedList<Integer> orgList) {
     orgList.add(1);
     orgList.add(2);
     orgList.add(3);
    }
}
