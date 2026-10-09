package abstraction_interface.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 3: College Fee Counter
 * Demonstrates Abstraction with an abstract Student class and Interface BusUser
 * to decouple bus transport capability and keep the fee in one place.
 */
public class CollegeFeeCounter {

    // Interface representing students who use the college bus
    public interface BusUser {
        // Transport fee is maintained in one place only
        double TRANSPORT_FEE = 12000.0;

        default double getTransportFee() {
            return TRANSPORT_FEE;
        }
    }

    // Abstract class representing a generic student
    public static abstract class Student {
        protected String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract double getTuitionFee();

        public double getHostelFee() {
            return 0.0;
        }

        public double calculateTotalFee() {
            double fee = getTuitionFee() + getHostelFee();
            if (this instanceof BusUser busUser) {
                fee += busUser.getTransportFee();
            }
            return fee;
        }
    }

    public static class DayScholar extends Student implements BusUser {
        public DayScholar(String name) {
            super(name);
        }

        @Override
        public double getTuitionFee() {
            return 40000.0;
        }
    }

    public static class Hosteller extends Student {
        public Hosteller(String name) {
            super(name);
        }

        @Override
        public double getTuitionFee() {
            return 40000.0;
        }

        @Override
        public double getHostelFee() {
            return 60000.0;
        }
    }

    public static class ScholarshipStudent extends Student implements BusUser {
        public ScholarshipStudent(String name) {
            super(name);
        }

        @Override
        public double getTuitionFee() {
            // Half of normal tuition (40000 / 2 = 20000)
            return 20000.0;
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
            String type = scanner.next();
            String name = scanner.next();

            Student student;
            switch (type.toUpperCase()) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown student type: " + type);
            }

            double fee = student.calculateTotalFee();
            totalCollected += fee;
            System.out.printf(Locale.US, "%s: %.2f%n", student.getName(), fee);
        }

        System.out.printf(Locale.US, "Total Collected: %.2f%n", totalCollected);
        scanner.close();
    }
}
