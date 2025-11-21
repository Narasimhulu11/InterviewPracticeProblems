package org.example.tesco.container;

import java.util.*;


public class SetTest {
    public static void main(String args[]){
        Set<Dinmension> set = new HashSet<>();
        set.add(new Dinmension(1,2,3));
        set.add(new Dinmension(3,4,5));
        set.add(new Dinmension(4,5,6));
        System.out.println(set.size());
        int a = 10;
        Integer b= new Integer(20);
        int c = b;
        System.out.println("b: "+b);
        System.out.println("c: "+c);
        TreeSet<Dinmension> treeSet = new TreeSet<Dinmension>((o1, o2) -> (int) (o1.length-o2.length));
        treeSet.add(new Dinmension(4,2,3));
        treeSet.add(new Dinmension(2,4,5));
        treeSet.add(new Dinmension(3,5,6));
      //  Collections.sort(list, (o1, o2) -> (int) (o1.getEmpId()-o2.getEmpId()));
        treeSet.forEach(x->System.out.print(x.length+" "));
      /*  TreeMap<Dinmension,Integer> map = new TreeMap<>();
        map.put(new Dinmension(4,2,3),1);
        map.put(new Dinmension(2,4,5),2);
        map.put(new Dinmension(3,5,6),3);
        System.out.println();
        map.entrySet().forEach(x->System.out.println(x.getKey().length+" "+x.getKey().breadth+" "+x.getKey().height));
        List<Employeee> list = new ArrayList<>();
        list.addAll(Arrays.asList(new Employeee(1L,23L,"se"),
                new Employeee(5L,12L,"te"),
                new Employeee(3L,50L,"de"), new Employeee(1L,36L,"ae")));

       // Collections.sort(list);
        Collections.sort(list, (o1, o2) -> (int) (o1.getEmpId()-o2.getEmpId()));

        Collections.sort(list, Comparator.comparing(Employeee::getDesignation));

        list.forEach(x->System.out.println(x.toString()));*/
    }
}
