package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 2: Parcel Shipping Desk
 * Demonstrates Abstraction and Interface segregation:
 * Abstract class Parcel handles shipping charge calculation,
 * while interface Insurable provides the capability for parcels that can be insured.
 */
public class ParcelShippingDesk {

    // Interface representing insurable capability
    public interface Insurable {
        double calculateInsurance();
    }

    // Abstract class representing a generic parcel
    public static abstract class Parcel {
        protected double weight;
        protected double declaredValue;

        public Parcel(double weight, double declaredValue) {
            this.weight = weight;
            this.declaredValue = declaredValue;
        }

        public double getWeight() {
            return weight;
        }

        public double getDeclaredValue() {
            return declaredValue;
        }

        public abstract double calculateShippingCharge();
    }

    public static class StandardParcel extends Parcel {
        public StandardParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            return 40.0 + (10.0 * weight);
        }
    }

    public static class ExpressParcel extends Parcel implements Insurable {
        public ExpressParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            return 80.0 + (15.0 * weight);
        }

        @Override
        public double calculateInsurance() {
            return 0.02 * declaredValue;
        }
    }

    public static class FragileParcel extends Parcel implements Insurable {
        public FragileParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            // Fragile: the standard charge plus a handling fee of 50
            double standardCharge = 40.0 + (10.0 * weight);
            return standardCharge + 50.0;
        }

        @Override
        public double calculateInsurance() {
            return 0.02 * declaredValue;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();

            Parcel parcel;
            switch (type.toUpperCase()) {
                case "STANDARD":
                    parcel = new StandardParcel(weight, declaredValue);
                    break;
                case "EXPRESS":
                    parcel = new ExpressParcel(weight, declaredValue);
                    break;
                case "FRAGILE":
                    parcel = new FragileParcel(weight, declaredValue);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown parcel type: " + type);
            }

            double charge = parcel.calculateShippingCharge();
            double insurance = 0.0;
            if (parcel instanceof Insurable insurable) {
                insurance = insurable.calculateInsurance();
            }

            double total = charge + insurance;
            grandTotal += total;

            System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type.toUpperCase(), charge, insurance, total);
        }

        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
        scanner.close();
    }
}

