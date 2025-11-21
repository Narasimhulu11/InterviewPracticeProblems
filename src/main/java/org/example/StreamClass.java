
package org.example;


import java.util.*;
import java.util.stream.Collectors;
class Item{
 String name;
 long price;
 long quantity;

    public Item( String name, long price,long quantity) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }
}
public class StreamClass {
    public static void main(String args[]) {
        Map<String,Integer> map = new HashMap<>();
        map.put("vivek", 100);
        map.put("Rinku", 400);
        map.put("vishal", 600);
        map.put("shankar", 500);
        map.put("shyam", 500);
        map.put("tinku", 300);
      Map<String,Integer> map1 =  map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
              .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> b, LinkedHashMap::new));

      System.out.println(map1);
      List<Map.Entry<String,Integer>> result = map.entrySet().stream()
              .collect(Collectors.groupingBy(k->k.getValue())).entrySet()
              .stream()
              .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
              .skip(1).findFirst().get().getValue();
        System.out.println(result);

        List<Item> items = Arrays.asList(new Item("pen",10, 2), new Item("book", 20,3),new Item("pencil", 30, 4));
        double averagePrice = items.stream()
                .mapToDouble(item -> item.price)
                .average()
                .orElse(0.0);
                 System.out.println("avg : "+averagePrice);

        // .collect(Collectors.toMap(Map.Entry::getKey , Map.Entry::getValue, (a,b) -> b , HashMap::new));
              // .forEach(x -> System.out.println(x.getKey() + " : "+x.getValue()));
    }

  /*  private static boolean getSal(Map<String, Integer> map, int n) {
       // Map.Entry<String,Integer> = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).map()
        String str = "abcdeab";
        List<Character> list = Arrays.asList(str.toCharArray()[]);
        return list.stream().filter((a,b) -> a==b).findAny();
    }*/
}

