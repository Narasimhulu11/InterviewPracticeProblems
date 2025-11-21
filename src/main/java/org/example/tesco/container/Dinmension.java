package org.example.tesco.container;


import java.util.Objects;

public class Dinmension implements Comparable{
    public int length;
    public int breadth;
    public int height;
    public Dinmension(int l, int b, int h){
        this.length = l;
        this.breadth = b;
        this.height = h;
    }
    public int len(){
        return this.length;
    }
    public int br(){
        return this.breadth;
    }
    public int he(){
        return this.height;
    }

  /*  @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dinmension dinmension = (Dinmension) o;
        return length == dinmension.length && breadth == dinmension.breadth && height == dinmension.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, breadth, height);
    }*/

    @Override
    public int compareTo(Object o) {
        Dinmension d = (Dinmension) o;
        return length-d.length;
    }

    public Object getEmpId() {
        return null;
    }
}
