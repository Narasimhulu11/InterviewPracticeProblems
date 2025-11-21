package org.example.tesco.container;

public class Container extends Dinmension{
    private int id;
    public Container(int id , int l, int b , int h){
        super(l,b,h);
        this.id=id;
    }
    public int getId(){
        return this.id;
    }
}
