package abstraction.assignment_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 1: Movie Ticket Counter
 * Demonstrates Abstraction using an abstract class Ticket and concrete subclasses.
 */
public class MovieTicketCounter {

    // Abstract class representing a generic ticket.
    // Cannot be instantiated directly (a plain "ticket" with no seat type must never be sold).
    public static abstract class Ticket {
        // Convenience fee is defined in one place only
        private static final double CONVENIENCE_FEE = 20.0;
        protected int count;

        public Ticket(int count) {
            this.count = count;
        }

        public abstract double getBasePrice();

        public double calculateTotal() {
            return count * (getBasePrice() + CONVENIENCE_FEE);
        }
    }

    public static class RegularTicket extends Ticket {
        public RegularTicket(int count) {
            super(count);
        }

        @Override
        public double getBasePrice() {
            return 150.0;
        }
    }

    public static class PremiumTicket extends Ticket {
        public PremiumTicket(int count) {
            super(count);
        }

        @Override
        public double getBasePrice() {
            return 250.0;
        }
    }

    public static class ReclinerTicket extends Ticket {
        public ReclinerTicket(int count) {
            super(count);
        }

        @Override
        public double getBasePrice() {
            return 400.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();

            Ticket ticket;
            switch (seat.toUpperCase()) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket(count);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown seat type: " + seat);
            }

            double amount = ticket.calculateTotal();
            totalCollected += amount;
            System.out.printf(Locale.US, "%s: %.2f%n", seat.toUpperCase(), amount);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", totalCollected);
        scanner.close();
    }
}

