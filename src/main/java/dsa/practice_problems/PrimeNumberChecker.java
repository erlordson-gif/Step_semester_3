package dsa.practice_problems;

import java.util.Scanner;

/**
 * Category C · Part A — Coding Problems
 * Problem 6: Prime Number Checker
 *
 * TASK:
 * Write a program that reads a number greater than 1 and determines whether it is a prime number. A
 * prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
 * Print whether the number is prime or not.
 *
 * EXAMPLE:
 * Sample Input: 29
 *               21
 * Expected Output: 29 is prime
 *                  21 is not prime
 *
 * HINT:
 * To check for primality, iterate from 2 up to the square root of the number. If any number in this range
 * divides the input number evenly, it's not prime.
 */
public class PrimeNumberChecker {

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static String checkPrimeMessage(int n) {
        return n + (isPrime(n) ? " is prime" : " is not prime");
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 6: Prime Number Checker Demo ===");
        int[] samples = {29, 21};
        for (int s : samples) {
            System.out.println(checkPrimeMessage(s));
        }

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextInt()) {
                    int val = scanner.nextInt();
                    System.out.println(checkPrimeMessage(val));
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
