package interviews.java8;

import java.util.Date;

public final class  FinalClassExamples {
    private final int primitiveInt=1;
    private final Integer objectInt;
    private final Date mutableDate;
    private final Date immutableDate;
    FinalClassExamples(int i,Date date){
        this.objectInt=i;
        //defensive copy
        this.immutableDate= new Date(date.getTime());
        //referrence copy
        this.mutableDate=date;
    }


    public static void main(String[] args) {
        Integer integer=2;
        Date date= new Date();
       FinalClassExamples finalClassExamples= new FinalClassExamples(integer,
               date);
        System.out.println(finalClassExamples.primitiveInt);
        System.out.println(finalClassExamples.objectInt);
        System.out.println(finalClassExamples.mutableDate);
        System.out.println(finalClassExamples.immutableDate);
       integer=3;
       date.setTime(new Date(2024,11,11).getTime());
       System.out.println(finalClassExamples.primitiveInt);
        System.out.println(finalClassExamples.objectInt);
        System.out.println(finalClassExamples.mutableDate);
        System.out.println(finalClassExamples.immutableDate);
    }
}
