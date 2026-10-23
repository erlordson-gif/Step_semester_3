package abstraction.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Category C · Part A — Coding Problems
 * Problem 5: Travel Booking with a Common Fee
 *
 * TASK:
 * A travel website sells bus, train, and flight tickets. The fare depends on the travel mode and the distance,
 * but every booking — whatever the mode — also adds the same booking fee of 50. The fee must be
 * written in one place only.
 * If the booking fee changes, only one line of code should need to change.
 *
 * BUSINESS RULES:
 * • Bus fare: 2 per km.
 * • Train fare: 1.5 per km.
 * • Flight fare: 2500 plus 4 per km.
 * • Every booking adds a booking fee of 50 to the fare.
 *
 * EXAMPLE:
 * Sample Input:
 * 3
 * BUS 200
 * TRAIN 300
 * FLIGHT 500
 *
 * Expected Output:
 * BUS: 450.00
 * TRAIN: 500.00
 * FLIGHT: 4550.00
 *
 * HINT:
 * Consider how to implement a shared booking fee across different travel modes while allowing each
 * mode to calculate its base fare uniquely. An abstract base class could handle the common fee, with
 * subclasses implementing the mode-specific fare calculation.
 */
public class TravelBookingWithCommonFee {

    public static abstract class TravelBooking {
        // The booking fee is defined in one place only
        private static final double BOOKING_FEE = 50.0;

        protected String modeName;
        protected double distanceKm;

        public TravelBooking(String modeName, double distanceKm) {
            this.modeName = modeName;
            this.distanceKm = distanceKm;
        }

        public String getModeName() {
            return modeName;
        }

        public double getDistanceKm() {
            return distanceKm;
        }

        /**
         * Mode-specific base fare calculation implemented by subclasses.
         */
        public abstract double calculateBaseFare();

        /**
         * Common total calculation adding the uniform booking fee.
         */
        public double calculateTotalFare() {
            return calculateBaseFare() + BOOKING_FEE;
        }

        public String formatBookingLine() {
            return String.format(Locale.US, "%s: %.2f", modeName.toUpperCase(), calculateTotalFare());
        }
    }

    public static class BusBooking extends TravelBooking {
        public BusBooking(double distanceKm) {
            super("BUS", distanceKm);
        }

        @Override
        public double calculateBaseFare() {
            return distanceKm * 2.0;
        }
    }

    public static class TrainBooking extends TravelBooking {
        public TrainBooking(double distanceKm) {
            super("TRAIN", distanceKm);
        }

        @Override
        public double calculateBaseFare() {
            return distanceKm * 1.5;
        }
    }

    public static class FlightBooking extends TravelBooking {
        public FlightBooking(double distanceKm) {
            super("FLIGHT", distanceKm);
        }

        @Override
        public double calculateBaseFare() {
            return 2500.0 + (distanceKm * 4.0);
        }
    }

    public static void printBookings(List<TravelBooking> bookings) {
        for (TravelBooking b : bookings) {
            System.out.println(b.formatBookingLine());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Travel Booking with a Common Fee Demo ===");
        List<TravelBooking> sample = new ArrayList<>();
        sample.add(new BusBooking(200));
        sample.add(new TrainBooking(300));
        sample.add(new FlightBooking(500));
        printBookings(sample);

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    int n = scanner.nextInt();
                    List<TravelBooking> inputList = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        String mode = scanner.next();
                        double dist = scanner.nextDouble();
                        if (mode.equalsIgnoreCase("BUS")) {
                            inputList.add(new BusBooking(dist));
                        } else if (mode.equalsIgnoreCase("TRAIN")) {
                            inputList.add(new TrainBooking(dist));
                        } else if (mode.equalsIgnoreCase("FLIGHT")) {
                            inputList.add(new FlightBooking(dist));
                        }
                    }
                    printBookings(inputList);
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
