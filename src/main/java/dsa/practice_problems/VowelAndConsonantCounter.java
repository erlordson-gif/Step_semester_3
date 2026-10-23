package dsa.practice_problems;

import java.util.Scanner;

/**
 * Category C · Part A — Coding Problems
 * Problem 1: Vowel and Consonant Counter
 *
 * TASK:
 * Write a program that reads a single word and then counts and prints the total number of vowels and
 * consonants in that word. Assume the input word contains only alphabetic characters (case-insensitive).
 *
 * EXAMPLE:
 * Sample Input: Programming
 * Expected Output: Vowels: 3
 *                  Consonants: 8
 */
public class VowelAndConsonantCounter {

    public static class CountResult {
        public final int vowels;
        public final int consonants;

        public CountResult(int vowels, int consonants) {
            this.vowels = vowels;
            this.consonants = consonants;
        }

        @Override
        public String toString() {
            return "Vowels: " + vowels + "\nConsonants: " + consonants;
        }
    }

    public static CountResult countVowelsAndConsonants(String word) {
        if (word == null) {
            return new CountResult(0, 0);
        }

        int vowels = 0;
        int consonants = 0;
        String lower = word.toLowerCase();

        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);
            if (Character.isLetter(ch)) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        return new CountResult(vowels, consonants);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Vowel and Consonant Counter Demo ===");
        String sample = "Programming";
        CountResult result = countVowelsAndConsonants(sample);
        System.out.println("Sample Input: " + sample);
        System.out.println(result);

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNext()) {
                    String word = scanner.next();
                    System.out.println(countVowelsAndConsonants(word));
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
