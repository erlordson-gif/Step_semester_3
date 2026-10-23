package abstraction.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Category C · Part A — Coding Problems
 * Problem 4: Electricity Connection Billing
 *
 * TASK:
 * The electricity board issues monthly bills to homes, shops, and factories. Every connection has a number
 * of units used, but each connection type calculates its bill differently. The board needs each connection's
 * bill and the total amount billed.
 *
 * BUSINESS RULES:
 * • Home: 5 per unit for the first 100 units and 7 per unit after that.
 * • Shop: 8 per unit plus a fixed charge of 100.
 * • Factory: 6 per unit, with a minimum bill of 1000.
 *
 * EXAMPLE:
 * Sample Input:
 * 3
 * HOME 150
 * SHOP 90
 * FACTORY 120
 *
 * Expected Output:
 * HOME: 850.00
 * SHOP: 820.00
 * FACTORY: 1000.00
 * Total: 2670.00
 */
public class ElectricityConnectionBilling {

    public static abstract class Connection {
        protected String typeName;
        protected double units;

        public Connection(String typeName, double units) {
            this.typeName = typeName;
            this.units = units;
        }

        public String getTypeName() {
            return typeName;
        }

        public double getUnits() {
            return units;
        }

        public abstract double calculateBill();

        public String formatBillLine() {
            return String.format(Locale.US, "%s: %.2f", typeName.toUpperCase(), calculateBill());
        }
    }

    public static class HomeConnection extends Connection {
        public HomeConnection(double units) {
            super("HOME", units);
        }

        @Override
        public double calculateBill() {
            if (units <= 100) {
                return units * 5.0;
            } else {
                return (100 * 5.0) + ((units - 100) * 7.0);
            }
        }
    }

    public static class ShopConnection extends Connection {
        private static final double FIXED_CHARGE = 100.0;

        public ShopConnection(double units) {
            super("SHOP", units);
        }

        @Override
        public double calculateBill() {
            return (units * 8.0) + FIXED_CHARGE;
        }
    }

    public static class FactoryConnection extends Connection {
        private static final double MIN_BILL = 1000.0;

        public FactoryConnection(double units) {
            super("FACTORY", units);
        }

        @Override
        public double calculateBill() {
            double bill = units * 6.0;
            return Math.max(bill, MIN_BILL);
        }
    }

    public static void printBillingReport(List<Connection> connections) {
        double totalBilled = 0.0;
        for (Connection c : connections) {
            System.out.println(c.formatBillLine());
            totalBilled += c.calculateBill();
        }
        System.out.printf(Locale.US, "Total: %.2f%n", totalBilled);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Electricity Connection Billing Demo ===");
        List<Connection> sample = new ArrayList<>();
        sample.add(new HomeConnection(150));
        sample.add(new ShopConnection(90));
        sample.add(new FactoryConnection(120));
        printBillingReport(sample);

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    int n = scanner.nextInt();
                    List<Connection> inputList = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        String type = scanner.next();
                        double units = scanner.nextDouble();
                        if (type.equalsIgnoreCase("HOME")) {
                            inputList.add(new HomeConnection(units));
                        } else if (type.equalsIgnoreCase("SHOP")) {
                            inputList.add(new ShopConnection(units));
                        } else if (type.equalsIgnoreCase("FACTORY")) {
                            inputList.add(new FactoryConnection(units));
                        }
                    }
                    printBillingReport(inputList);
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
