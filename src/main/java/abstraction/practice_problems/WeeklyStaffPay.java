package abstraction.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Category C · Part A — Coding Problems
 * Problem 2: Weekly Staff Pay
 *
 * TASK:
 * A small company pays three kinds of staff every week: full-time staff receive a fixed weekly salary,
 * hourly staff are paid by the hour with overtime, and interns receive a fixed stipend. Every staff member
 * has a name, and the payroll screen must list each person's pay and the total.
 * A generic "staff member" with no pay rule must never be created.
 *
 * BUSINESS RULES:
 * • Full-time staff are paid their fixed weekly salary.
 * • Hourly staff are paid rate for the first 40 hours and 1.5 × rate for every hour above 40.
 * • Interns are paid their fixed stipend.
 *
 * EXAMPLE:
 * Sample Input:
 * 3
 * FULLTIME Asha 12000
 * HOURLY Ravi 45 200
 * INTERN Neha 5000
 *
 * Expected Output:
 * Asha: 12000.00
 * Ravi: 9500.00
 * Neha: 5000.00
 * Total Payroll: 26500.00
 */
public class WeeklyStaffPay {

    public static abstract class Staff {
        protected String name;

        public Staff(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract double calculatePay();

        public String formatPayrollLine() {
            return String.format(Locale.US, "%s: %.2f", name, calculatePay());
        }
    }

    public static class FullTimeStaff extends Staff {
        private double weeklySalary;

        public FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        @Override
        public double calculatePay() {
            return weeklySalary;
        }
    }

    public static class HourlyStaff extends Staff {
        private double hours;
        private double rate;

        public HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        public double calculatePay() {
            if (hours <= 40) {
                return hours * rate;
            } else {
                double regularPay = 40 * rate;
                double overtimePay = (hours - 40) * (1.5 * rate);
                return regularPay + overtimePay;
            }
        }
    }

    public static class Intern extends Staff {
        private double stipend;

        public Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        @Override
        public double calculatePay() {
            return stipend;
        }
    }

    public static void printPayroll(List<Staff> staffList) {
        double totalPayroll = 0.0;
        for (Staff s : staffList) {
            System.out.println(s.formatPayrollLine());
            totalPayroll += s.calculatePay();
        }
        System.out.printf(Locale.US, "Total Payroll: %.2f%n", totalPayroll);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Weekly Staff Pay Demo ===");
        List<Staff> sample = new ArrayList<>();
        sample.add(new FullTimeStaff("Asha", 12000));
        sample.add(new HourlyStaff("Ravi", 45, 200));
        sample.add(new Intern("Neha", 5000));
        printPayroll(sample);

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    int n = scanner.nextInt();
                    List<Staff> inputList = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        String type = scanner.next();
                        String name = scanner.next();
                        if (type.equalsIgnoreCase("FULLTIME")) {
                            double sal = scanner.nextDouble();
                            inputList.add(new FullTimeStaff(name, sal));
                        } else if (type.equalsIgnoreCase("HOURLY")) {
                            double hours = scanner.nextDouble();
                            double rate = scanner.nextDouble();
                            inputList.add(new HourlyStaff(name, hours, rate));
                        } else if (type.equalsIgnoreCase("INTERN")) {
                            double stipend = scanner.nextDouble();
                            inputList.add(new Intern(name, stipend));
                        }
                    }
                    printPayroll(inputList);
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
