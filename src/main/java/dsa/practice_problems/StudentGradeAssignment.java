package dsa.practice_problems;

import java.util.Scanner;

/**
 * Category C · Part A — Coding Problems
 * Problem 8: Student Grade Assignment
 *
 * TASK:
 * Write a program that reads a student's marks (out of 100) and prints their corresponding grade based on
 * the following criteria:
 * • A: 90 or above
 * • B: 75 to 89
 * • C: 60 to 74
 * • D: 40 to 59
 * • F: Below 40
 *
 * EXAMPLE:
 * Sample Input: 72
 *               95
 *               35
 * Expected Output: Grade C
 *                  Grade A
 *                  Grade F
 *
 * HINT:
 * Use an if-else if-else ladder to check the conditions in the correct order, starting from the highest grade boundary.
 */
public class StudentGradeAssignment {

    public static String assignGrade(int marks) {
        if (marks >= 90) {
            return "Grade A";
        } else if (marks >= 75) {
            return "Grade B";
        } else if (marks >= 60) {
            return "Grade C";
        } else if (marks >= 40) {
            return "Grade D";
        } else {
            return "Grade F";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 8: Student Grade Assignment Demo ===");
        int[] samples = {72, 95, 35};
        for (int m : samples) {
            System.out.println("Marks: " + m + " -> " + assignGrade(m));
        }

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextInt()) {
                    int marks = scanner.nextInt();
                    System.out.println(assignGrade(marks));
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
