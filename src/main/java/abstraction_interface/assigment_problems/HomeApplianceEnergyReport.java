package abstraction_interface.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 5: Home Appliance Energy Report
 * Demonstrates Abstraction with an abstract Appliance class and an interface SaverMode
 * to allow supported appliances to apply energy saver reductions dynamically.
 */
public class HomeApplianceEnergyReport {

    // Interface representing appliances that support saver mode
    public interface SaverMode {
        default double applySaverDiscount(double normalUnits) {
            // Reduces energy units by 25%
            return normalUnits * 0.75;
        }
    }

    // Abstract class representing a generic appliance
    public static abstract class Appliance {
        // Electricity rate: 8 per kWh
        protected static final double COST_PER_KWH = 8.0;

        public abstract double getPowerRating();

        public double calculateUnits(double hours) {
            return (getPowerRating() * hours) / 1000.0;
        }

        public double calculateCost(double units) {
            return units * COST_PER_KWH;
        }
    }

    public static class Fridge extends Appliance {
        @Override
        public double getPowerRating() {
            return 150.0;
        }
    }

    public static class AirConditioner extends Appliance implements SaverMode {
        @Override
        public double getPowerRating() {
            return 1500.0;
        }
    }

    public static class Television extends Appliance {
        @Override
        public double getPowerRating() {
            return 100.0;
        }
    }

    public static class WashingMachine extends Appliance implements SaverMode {
        @Override
        public double getPowerRating() {
            return 500.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }

        String firstLine = scanner.nextLine().trim();
        while (firstLine.isEmpty() && scanner.hasNextLine()) {
            firstLine = scanner.nextLine().trim();
        }
        if (firstLine.isEmpty()) {
            scanner.close();
            return;
        }

        int n = Integer.parseInt(firstLine);
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) {
                break;
            }
            String line = scanner.nextLine().trim();
            while (line.isEmpty() && scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
            }
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");
            String applianceType = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saverRequested = parts.length > 2 && parts[2].equalsIgnoreCase("SAVER");

            Appliance appliance;
            switch (applianceType.toUpperCase()) {
                case "FRIDGE":
                    appliance = new Fridge();
                    break;
                case "AC":
                    appliance = new AirConditioner();
                    break;
                case "TV":
                    appliance = new Television();
                    break;
                case "WASHER":
                    appliance = new WashingMachine();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown appliance: " + applianceType);
            }

            if (saverRequested) {
                if (appliance instanceof SaverMode saverAppliance) {
                    double normalUnits = appliance.calculateUnits(hours);
                    double units = saverAppliance.applySaverDiscount(normalUnits);
                    double cost = appliance.calculateCost(units);
                    totalCost += cost;
                    System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n",
                            applianceType.toUpperCase(), units, cost);
                } else {
                    System.out.printf("%s: saver mode not supported%n", applianceType.toUpperCase());
                }
            } else {
                double units = appliance.calculateUnits(hours);
                double cost = appliance.calculateCost(units);
                totalCost += cost;
                System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n",
                        applianceType.toUpperCase(), units, cost);
            }
        }

        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
        scanner.close();
    }
}
