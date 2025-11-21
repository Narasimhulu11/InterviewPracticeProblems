package interviews;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Testt {
    public static void main(String args[]) throws InterruptedException {
        List<Integer> list = Arrays.asList(1,2,3);
        List<Integer> sqList = list.stream().map(x->x*x).collect(Collectors.toList());
        List<Employee> emplist = new ArrayList<>();
        sqList.forEach(System.out::print);
        List<List<Integer>> res = new ArrayList<>();
        res.add(list);
        res.add(sqList);
        System.out.println();
        List<Integer> flatList = res.stream().flatMap(x->x.stream()).distinct().collect(Collectors.toList());
        flatList.forEach(System.out::print);
        Collections.sort(emplist, Comparator.comparing(Employee::getId));
        Collections.sort(emplist, Comparator.comparing(Employee::getName));

    }
}