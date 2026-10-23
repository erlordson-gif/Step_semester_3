package dsa.practice_problems;

import java.util.Scanner;

/**
 * Category C · Part A — Coding Problems
 * Problem 2: Word Reverser and Palindrome Checker
 *
 * TASK:
 * Create a program that reads a word, reverses it using a mutable text builder (like StringBuilder in Java),
 * and then prints the reversed word. Additionally, determine and print whether the original word reads the
 * same forwards and backwards (is a palindrome).
 *
 * EXAMPLE:
 * Sample Input: level
 *               java
 * Expected Output: level - palindrome
 *                  avaj - not a palindrome
 */
public class WordReverserAndPalindromeChecker {

    public static String checkWord(String word) {
        if (word == null) return "";
        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        boolean isPalindrome = word.equalsIgnoreCase(reversed);
        return reversed + (isPalindrome ? " - palindrome" : " - not a palindrome");
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Word Reverser and Palindrome Checker Demo ===");
        String[] samples = {"level", "java"};
        for (String s : samples) {
            System.out.println(checkWord(s));
        }

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNext()) {
                    String w = scanner.next();
                    System.out.println(checkWord(w));
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
