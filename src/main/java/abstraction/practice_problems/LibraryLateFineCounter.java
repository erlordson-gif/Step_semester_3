package abstraction.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Category C · Part A — Coding Problems
 * Problem 3: Library Late Fine Counter
 *
 * TASK:
 * A library charges a fine when borrowed items are returned late. Books, DVDs, and magazines each follow
 * a different fine rule. Every item has a title and a number of days late. The library needs the fine for each
 * item and the total fines collected.
 *
 * BUSINESS RULES:
 * • Books: 2 per day late.
 * • DVDs: 5 per day late, up to a maximum of 50.
 * • Magazines: 1 per day late.
 *
 * EXAMPLE:
 * Sample Input:
 * 3
 * BOOK Algebra 4
 * DVD Inception 12
 * MAGAZINE Sports 3
 *
 * Expected Output:
 * Algebra: 8.00
 * Inception: 50.00
 * Sports: 3.00
 * Total Fines: 61.00
 */
public class LibraryLateFineCounter {

    public static abstract class LibraryItem {
        protected String title;
        protected int daysLate;

        public LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        public String getTitle() {
            return title;
        }

        public int getDaysLate() {
            return daysLate;
        }

        public abstract double calculateFine();

        public String formatFineLine() {
            return String.format(Locale.US, "%s: %.2f", title, calculateFine());
        }
    }

    public static class Book extends LibraryItem {
        public Book(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            return daysLate * 2.0;
        }
    }

    public static class Dvd extends LibraryItem {
        private static final double MAX_FINE = 50.0;

        public Dvd(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            double fine = daysLate * 5.0;
            return Math.min(fine, MAX_FINE);
        }
    }

    public static class Magazine extends LibraryItem {
        public Magazine(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            return daysLate * 1.0;
        }
    }

    public static void printFinesReport(List<LibraryItem> items) {
        double totalFines = 0.0;
        for (LibraryItem item : items) {
            System.out.println(item.formatFineLine());
            totalFines += item.calculateFine();
        }
        System.out.printf(Locale.US, "Total Fines: %.2f%n", totalFines);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Library Late Fine Counter Demo ===");
        List<LibraryItem> sample = new ArrayList<>();
        sample.add(new Book("Algebra", 4));
        sample.add(new Dvd("Inception", 12));
        sample.add(new Magazine("Sports", 3));
        printFinesReport(sample);

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    int n = scanner.nextInt();
                    List<LibraryItem> inputList = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        String type = scanner.next();
                        String title = scanner.next();
                        int days = scanner.nextInt();
                        if (type.equalsIgnoreCase("BOOK")) {
                            inputList.add(new Book(title, days));
                        } else if (type.equalsIgnoreCase("DVD")) {
                            inputList.add(new Dvd(title, days));
                        } else if (type.equalsIgnoreCase("MAGAZINE")) {
                            inputList.add(new Magazine(title, days));
                        }
                    }
                    printFinesReport(inputList);
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
