package interviews.java8;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set.");
        }
        paymentStrategy.pay(amount);
    }
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Using Factory to get the payment method
        PaymentStrategy paymentMethod = PaymentFactory.getPaymentMethod("CreditCard");
        cart.setPaymentStrategy(paymentMethod);
        cart.checkout(100.0);

        // Change payment method
        paymentMethod = PaymentFactory.getPaymentMethod("PayPal");
        cart.setPaymentStrategy(paymentMethod);
        cart.checkout(200.0);
    }
}