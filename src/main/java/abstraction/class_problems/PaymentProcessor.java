package abstraction.class_problems;

import java.util.Locale;

/**
 * Class Problem 2: Payment Processor
 * Demonstrates the concept of Interfaces and Multiple Implementations in Java.
 */
public class PaymentProcessor {

    public interface PaymentGateway {
        boolean processPayment(double amount);
        String getPaymentMethodName();
    }

    public static class CreditCardPayment implements PaymentGateway {
        private String cardNumber;

        public CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        @Override
        public boolean processPayment(double amount) {
            System.out.printf(Locale.US, "Processing Credit Card payment of $%.2f for card ending in %s%n",
                    amount, cardNumber.substring(Math.max(0, cardNumber.length() - 4)));
            return true;
        }

        @Override
        public String getPaymentMethodName() {
            return "Credit Card";
        }
    }

    public static class UpiPayment implements PaymentGateway {
        private String upiId;

        public UpiPayment(String upiId) {
            this.upiId = upiId;
        }

        @Override
        public boolean processPayment(double amount) {
            System.out.printf(Locale.US, "Processing UPI payment of $%.2f via %s%n", amount, upiId);
            return true;
        }

        @Override
        public String getPaymentMethodName() {
            return "UPI";
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Payment Processor Demo ---");
        PaymentGateway card = new CreditCardPayment("1234567890123456");
        PaymentGateway upi = new UpiPayment("student@okhdfcbank");

        card.processPayment(1500.00);
        upi.processPayment(500.00);
    }
}

