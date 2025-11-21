package interviews.java8;
/*
1. static fields stores in Metaspace.
2. static will load when class loads into JVM.
3. static can be accessed inside non static environment. but non static can not be accessed in static environment.
 */
public  class  StaticExamples {
    private static int  count=0;

    private int nonstacticField=1;

    private static double getDoubleValue(double doubleValue){
        count++;
        return count*doubleValue;

    }

    private int sum(){
        return count+=1;
    }

    static class  Square{
        static int getSquares(int n){
            return n*n;
        }

        void mnsd(){
           System.out.println("inside mnsd");
        }
    }

    public static void main(String[] args) {
        System.out.println(Square.getSquares(9));
        Square s= new Square();
        StaticExamples staticExamples= new StaticExamples();
        s.mnsd();
        staticExamples.sum();
        staticExamples.sum();
        System.out.println(StaticExamples.getDoubleValue(5));
        System.out.println(staticExamples.nonstacticField);
    }

}

