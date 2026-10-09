package abstraction_interface.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 4: City Cab Fare Meter
 * Demonstrates Abstraction with an abstract Cab class encapsulating base rate logic and minimum fare,
 * and an interface NightService to model optional night service capabilities.
 */
public class CityCabFareMeter {

    // Interface representing cabs that can offer night service
    public interface NightService {
        default double applyNightSurcharge(double baseFare) {
            return baseFare * 1.20;
        }
    }

    // Abstract class representing a generic cab
    public static abstract class Cab {
        // Shared minimum fare rule across all cab types
        protected static final double MINIMUM_FARE = 100.0;

        public abstract double getRatePerKm();

        public double calculateBaseFare(double distanceKm) {
            return Math.max(MINIMUM_FARE, distanceKm * getRatePerKm());
        }
    }

    public static class MiniCab extends Cab {
        @Override
        public double getRatePerKm() {
            return 10.0;
        }
    }

    public static class SedanCab extends Cab implements NightService {
        @Override
        public double getRatePerKm() {
            return 14.0;
        }
    }

    public static class SuvCab extends Cab implements NightService {
        @Override
        public double getRatePerKm() {
            return 18.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        double totalFare = 0.0;

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            Cab cab;
            switch (cabType.toUpperCase()) {
                case "MINI":
                    cab = new MiniCab();
                    break;
                case "SEDAN":
                    cab = new SedanCab();
                    break;
                case "SUV":
                    cab = new SuvCab();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cab type: " + cabType);
            }

            boolean isNight = time.equalsIgnoreCase("NIGHT");

            if (isNight) {
                if (cab instanceof NightService nightCab) {
                    double baseFare = cab.calculateBaseFare(km);
                    double fare = nightCab.applyNightSurcharge(baseFare);
                    totalFare += fare;
                    System.out.printf(Locale.US, "%s: %.2f%n", cabType.toUpperCase(), fare);
                } else {
                    System.out.printf("%s: night service not available%n", cabType.toUpperCase());
                }
            } else {
                double fare = cab.calculateBaseFare(km);
                totalFare += fare;
                System.out.printf(Locale.US, "%s: %.2f%n", cabType.toUpperCase(), fare);
            }
        }

        System.out.printf(Locale.US, "Total: %.2f%n", totalFare);
        scanner.close();
    }
}

