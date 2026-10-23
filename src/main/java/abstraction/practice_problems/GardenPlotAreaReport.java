package abstraction.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Category C · Part A — Coding Problems
 * Problem 1: Garden Plot Area Report
 *
 * TASK:
 * A community garden rents out plots of three shapes: circular, rectangular, and triangular. Every plot has
 * an owner, and every plot's area is calculated with a different formula. The garden office needs the area
 * of each plot and the total area rented.
 * Adding a new plot shape later should not require changes to the code that prints the report.
 *
 * BUSINESS RULES:
 * • Circle area = π × radius × radius (use Math.PI).
 * • Rectangle area = length × width.
 * • Triangle area = ½ × base × height.
 *
 * EXAMPLE:
 * Sample Input:
 * 3
 * CIRCLE Asha 5
 * RECTANGLE Ravi 4 6
 * TRIANGLE Neha 10 3
 *
 * Expected Output:
 * Asha (CIRCLE): 78.54
 * Ravi (RECTANGLE): 24.00
 * Neha (TRIANGLE): 15.00
 * Total Area: 117.54
 */
public class GardenPlotAreaReport {

    public static abstract class Plot {
        protected String owner;
        protected String shapeName;

        public Plot(String owner, String shapeName) {
            this.owner = owner;
            this.shapeName = shapeName;
        }

        public String getOwner() {
            return owner;
        }

        public String getShapeName() {
            return shapeName;
        }

        public abstract double getArea();

        public String formatReportLine() {
            return String.format(Locale.US, "%s (%s): %.2f", owner, shapeName.toUpperCase(), getArea());
        }
    }

    public static class CirclePlot extends Plot {
        private double radius;

        public CirclePlot(String owner, double radius) {
            super(owner, "CIRCLE");
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
    }

    public static class RectanglePlot extends Plot {
        private double length;
        private double width;

        public RectanglePlot(String owner, double length, double width) {
            super(owner, "RECTANGLE");
            this.length = length;
            this.width = width;
        }

        @Override
        public double getArea() {
            return length * width;
        }
    }

    public static class TrianglePlot extends Plot {
        private double base;
        private double height;

        public TrianglePlot(String owner, double base, double height) {
            super(owner, "TRIANGLE");
            this.base = base;
            this.height = height;
        }

        @Override
        public double getArea() {
            return 0.5 * base * height;
        }
    }

    public static void printReport(List<Plot> plots) {
        double totalArea = 0.0;
        for (Plot p : plots) {
            System.out.println(p.formatReportLine());
            totalArea += p.getArea();
        }
        System.out.printf(Locale.US, "Total Area: %.2f%n", totalArea);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Garden Plot Area Report Demo ===");
        List<Plot> samplePlots = new ArrayList<>();
        samplePlots.add(new CirclePlot("Asha", 5));
        samplePlots.add(new RectanglePlot("Ravi", 4, 6));
        samplePlots.add(new TrianglePlot("Neha", 10, 3));
        printReport(samplePlots);

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    int n = scanner.nextInt();
                    List<Plot> inputPlots = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        String type = scanner.next();
                        String owner = scanner.next();
                        if (type.equalsIgnoreCase("CIRCLE")) {
                            double r = scanner.nextDouble();
                            inputPlots.add(new CirclePlot(owner, r));
                        } else if (type.equalsIgnoreCase("RECTANGLE")) {
                            double l = scanner.nextDouble();
                            double w = scanner.nextDouble();
                            inputPlots.add(new RectanglePlot(owner, l, w));
                        } else if (type.equalsIgnoreCase("TRIANGLE")) {
                            double b = scanner.nextDouble();
                            double h = scanner.nextDouble();
                            inputPlots.add(new TrianglePlot(owner, b, h));
                        }
                    }
                    printReport(inputPlots);
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
