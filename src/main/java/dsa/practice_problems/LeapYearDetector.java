package dsa.practice_problems;

import java.util.Scanner;

/**
 * Category C · Part A — Coding Problems
 * Problem 9: Leap Year Detector
 *
 * TASK:
 * Write a program that reads a year and determines if it is a leap year. A year is a leap year if it is
 * divisible by 4, but not by 100, unless it is also divisible by 400.
 *
 * EXAMPLE:
 * Sample Input: 2024
 *               1900
 *               2000
 * Expected Output: Leap year
 *                  Not a leap year
 *                  Leap year
 *
 * HINT:
 * Formulate the conditions using logical operators (AND, OR) to implement the leap year rules. Check for
 * divisibility by 4, 100, and 400 in the correct logical sequence.
 */
public class LeapYearDetector {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static String getLeapYearStatus(int year) {
        return isLeapYear(year) ? "Leap year" : "Not a leap year";
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 9: Leap Year Detector Demo ===");
        int[] samples = {2024, 1900, 2000};
        for (int y : samples) {
            System.out.println("Year " + y + ": " + getLeapYearStatus(y));
        }

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextInt()) {
                    int year = scanner.nextInt();
                    System.out.println(getLeapYearStatus(year));
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
