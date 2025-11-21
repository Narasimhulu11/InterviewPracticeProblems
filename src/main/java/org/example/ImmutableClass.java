package org.example;

import java.util.Arrays;
import java.util.List;

public final class ImmutableClass {
    private final int id=1;
    private final List<Integer> list;
    public ImmutableClass(List<Integer> list){
        this.list = list;
    }
    public int getId(){
        return id;
    }

    public List<Integer> getList() {
        return list;
    }

    public static void main(String args[]){
        ImmutableClass immutableClass = new ImmutableClass(Arrays.asList(1,2,3));
        List<Integer> res = immutableClass.getList();
        res.forEach(System.out::print);
        ImmutableClass immutableClass1 = new ImmutableClass(Arrays.asList(2,3,4));
        List<Integer> res1 = immutableClass1.getList();
        res1.forEach(System.out::print);
    }
}
