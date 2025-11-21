package org.example;

import org.example.tesco.container.Container;
import org.example.tesco.container.Product;

import java.util.*;

public class Order {
    static Map<Product, Integer> order = new HashMap<>();
    public static void main(String args[]){
        Product p1 = new Product(1, 2, 4,10);
        Product p2 = new Product(3, 5,6,70000);
        order.put(p1, 3);
        order.put(p2,7);
        Long completeVol = getCompleteVolOfOrder(order);
        Container c1 = new Container(1,10,20,30);
        Container c2 = new Container(2,50,60,70);
        Container c3 = new Container(3,100,200,300);
        List<Container> containerList = Arrays.asList(c1,c2,c3);
        long containerVol = 0;
        int smallContainerId = -1;
        for(Container c: containerList){
            containerVol = c.len()*c.br()*c.he();
            if(completeVol <= containerVol ){
                smallContainerId = c.getId();
                break;
            }
        }

        System.out.println("complete order volume is : "+ completeVol);
        System.out.println("Container id is : "+ smallContainerId);

    }

    private static Long getCompleteVolOfOrder(Map<Product, Integer> oder) {
        long vol = 0;
        for(Map.Entry entry:order.entrySet() ){
            Product p = (Product) entry.getKey();
            Integer quantity = (Integer) entry.getValue();
            vol = vol + ( quantity * (p.len() * p.br() * p.he()));
        }
        return vol;
    }
}
