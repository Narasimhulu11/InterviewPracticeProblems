package interviews.java8;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentFactory {
    private static final Map<String, Supplier<PaymentStrategy>> registry = new HashMap<>();

    static {
        registry.put("CreditCard", CreditCardPayment::new);
        registry.put("PayPal", PayPalPayment::new);
    }

    public static void registerPaymentMethod(String type, Supplier<PaymentStrategy> supplier) {
        registry.put(type, supplier);
    }

    public static PaymentStrategy getPaymentMethod(String type) {
        Supplier<PaymentStrategy> supplier = registry.get(type);
        if (supplier != null) {
            return supplier.get();
        }
        throw new IllegalArgumentException("Unknown payment method: " + type);
    }
}
