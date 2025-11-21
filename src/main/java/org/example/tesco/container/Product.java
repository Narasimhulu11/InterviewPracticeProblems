package org.example.tesco.container;

public class Product extends Dinmension {
    private int id;
   // private long quantity;
    public Product(int id , int l, int b , int h){
        super(l,b,h);
        this.id=id;
    }
    public int len(){
        return super.length;
    }
    public int br(){
        return super.breadth;
    }
    public int he(){
        return super.height;
    }
}
