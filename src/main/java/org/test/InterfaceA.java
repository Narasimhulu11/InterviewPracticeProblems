package org.test;

public class InterfaceA {
    public static void main(String[] args) throws CloneNotSupportedException {
        Singleton s = Singleton.getSingletonObj();
        System.out.println(s.hashCode());
        Singleton s1= (Singleton) s.clone();
        System.out.println(s1.hashCode());
       /* Integer[] arr = {5, 13, 4, 21, 13, 27, 2, 59, 59, 34};
        Set<Integer> set = Stream.of(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .filter(x -> x.getValue() ==1).map(x->x.getKey()).collect(Collectors.toSet());
        System.out.println(set);
        String s = "geeksforgeeks";
        char target = 'e';
        int value = Math.toIntExact(s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream().filter(c -> c.getKey().charValue()==target).findFirst().get().getValue());
        System.out.println(value);*/
       /* List<Product> productsList = new ArrayList<Product>();
        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));
        List<Float> productPriceList = new ArrayList<Float>();
       *//* for(Product product: productsList){

            // filtering data of list
            if(product.price<30000){
                productPriceList.add(product.price);    // adding price to a productPriceList
            }
        }*//*
        productPriceList = productsList.stream().map(p->p.price).filter(p->p<30000).collect(Collectors.toList());
        Float totalPrice = productsList.stream().map(p->p.price).reduce(0.0f,(s,p) -> (s+p)).floatValue();
        System.out.println(totalPrice);   // displaying data*/
    }
}