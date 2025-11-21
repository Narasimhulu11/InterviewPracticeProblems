package interviews.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExamples {
    public static void main(String[] args) {
        Predicate<Integer> integerPredicate = t->t%2==0;
        Predicate<Integer> isPrime= t->t%3==0;

        System.out.println(integerPredicate.test(20));
        System.out.println(integerPredicate.and(isPrime).test(6));
        System.out.println(integerPredicate.and(isPrime).test(7));
        System.out.println(integerPredicate.negate().test(7));

        Supplier<CreditCardPayment> creditCardPaymentSupplier= ()-> new CreditCardPayment();

        System.out.println(creditCardPaymentSupplier.get());

        Consumer<Integer> consumer= (t)->System.out.println(t);

        consumer.accept(10);

        Function<Integer,String > function= String::valueOf;

        System.out.println(function.apply(12));
    }
}
