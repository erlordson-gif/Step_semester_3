package dsa.practice_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Category C · Part A — Coding Problems
 * Problem 10: Student Result Card Generator
 *
 * TASK:
 * Design a system for student result cards. Each student has a name and an array of three marks.
 * Implement a method to calculate the student's average mark. Based on the average, assign a grade using
 * the following conditions: 'B' for an average of 75 or more, 'D' for an average between 40 and 59
 * (inclusive), and other grades as per your design. Finally, print the student's name in capital letters, their
 * average mark (one decimal place), and their assigned grade.
 *
 * EXAMPLE:
 * Sample Input: Asha [80, 90, 70]
 *               Ravi [60, 55, 50]
 * Expected Output: ASHA: Average 80.0, Grade B
 *                  RAVI: Average 55.0, Grade D
 *
 * HINT:
 * Create a Student class with fields for name and marks array. Implement a method within the Student
 * class to calculate the average. Use conditional logic (if-else if-else) to determine the grade based on
 * the average. Convert the student's name to uppercase for printing.
 */
public class StudentResultCardGenerator {

    public static class Student {
        private String name;
        private int[] marks;

        public Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks != null ? marks : new int[0];
        }

        public double calculateAverage() {
            if (marks.length == 0) return 0.0;
            int sum = 0;
            for (int m : marks) {
                sum += m;
            }
            return (double) sum / marks.length;
        }

        public String determineGrade() {
            double avg = calculateAverage();
            if (avg >= 75.0) {
                return "Grade B";
            } else if (avg >= 60.0) {
                return "Grade C";
            } else if (avg >= 40.0) {
                return "Grade D";
            } else {
                return "Grade F";
            }
        }

        public String generateResultCard() {
            return String.format(Locale.US, "%s: Average %.1f, %s",
                    name.toUpperCase(), calculateAverage(), determineGrade());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 10: Student Result Card Generator Demo ===");
        Student s1 = new Student("Asha", new int[]{80, 90, 70});
        Student s2 = new Student("Ravi", new int[]{60, 55, 50});

        System.out.println(s1.generateResultCard());
        System.out.println(s2.generateResultCard());

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNext()) {
                    String name = scanner.next();
                    int[] marks = new int[3];
                    for (int i = 0; i < 3; i++) {
                        if (scanner.hasNextInt()) marks[i] = scanner.nextInt();
                    }
                    Student s = new Student(name, marks);
                    System.out.println(s.generateResultCard());
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
