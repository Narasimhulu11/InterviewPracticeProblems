package interviews.java8;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InterviewThreads {
    public static void main(String args[]){
        ExecutorService executorService= Executors.newFixedThreadPool(5);

        List<Integer> list= List.of(1,2,3,4,5,6,100);
        for(int i=0;i<list.size();i++){
            int finalI = i;
            executorService.execute(()->printList(list, finalI));
        }
        executorService.shutdown();
    }

    private static void printList(List<Integer> list, int finalI) {
        synchronized (list) {
            System.out.println(list.get(finalI));
            System.out.println(Thread.currentThread().getName());
        }
    }
}
