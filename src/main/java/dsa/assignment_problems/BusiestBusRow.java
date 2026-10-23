package dsa.assignment_problems;

import java.util.Scanner;

/**
 * Category C · Coding Assignment
 * Problem 10: Busiest Bus Row
 *
 * TASK:
 * A college bus records how many students sit in each seat as a 2D grid, where each row is one row of seats.
 * The transport office wants to know which row carries the most students.
 * Implement a function busiestRow(grid) that returns the index of the row with the largest total and that total.
 * If two rows tie, return the one with the smaller index.
 *
 * CONSTRAINTS:
 * • 1 <= rows, columns <= 10
 * • 0 <= grid[i][j] <= 3
 *
 * EXAMPLE:
 * grid = [[2, 0, 1],
 *         [3, 3, 1],
 *         [1, 1, 1]]
 * Expected Output: Row 1, Total 7
 *
 * COMPLEXITY REQUIREMENTS:
 * • Time Complexity:
 *     - O(r * c), where r is the number of rows and c is the number of columns in the grid.
 *     - Every cell is visited and summed exactly once.
 * • Space Complexity:
 *     - O(1) auxiliary space, requiring only a few integer variables to track current row sum, max sum, and best row index.
 * • Tie-breaking Rule:
 *     - Using strict inequality (rowTotal > maxTotal) ensures that if multiple rows share the same maximum total,
 *       the first row encountered (i.e. with the smaller row index) is preserved.
 *
 * HINT:
 * Use an outer loop for the rows and an inner loop to add up the seats in each row; update the best row
 * only when a total is strictly larger.
 */
public class BusiestBusRow {

    /**
     * Encapsulates the busiest row index and the total count of students in that row.
     */
    public static class RowResult {
        public final int rowIndex;
        public final int totalStudents;

        public RowResult(int rowIndex, int totalStudents) {
            this.rowIndex = rowIndex;
            this.totalStudents = totalStudents;
        }

        @Override
        public String toString() {
            return "Row " + rowIndex + ", Total " + totalStudents;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof RowResult)) return false;
            RowResult other = (RowResult) obj;
            return this.rowIndex == other.rowIndex && this.totalStudents == other.totalStudents;
        }

        @Override
        public int hashCode() {
            return 31 * rowIndex + totalStudents;
        }
    }

    /**
     * Determines the row index with the largest total students, and that total.
     * Ties are broken by choosing the smaller row index.
     *
     * @param grid 2D array representing student seat counts
     * @return RowResult containing the best rowIndex (0-indexed) and totalStudents
     */
    public static RowResult busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new RowResult(0, 0);
        }

        int bestRowIndex = 0;
        int maxTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int rowTotal = 0;
            if (grid[r] != null) {
                for (int c = 0; c < grid[r].length; c++) {
                    rowTotal += grid[r][c];
                }
            }

            // Update only when strictly larger to preserve the smaller index on tie
            if (rowTotal > maxTotal) {
                maxTotal = rowTotal;
                bestRowIndex = r;
            }
        }

        return new RowResult(bestRowIndex, maxTotal);
    }

    /**
     * Alternative helper method returning an array [rowIndex, totalStudents].
     */
    public static int[] busiestRowAsArray(int[][] grid) {
        RowResult res = busiestRow(grid);
        return new int[]{res.rowIndex, res.totalStudents};
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 10: Busiest Bus Row Demo ===");

        // Example from assignment
        int[][] grid = {
                {2, 0, 1},
                {3, 3, 1},
                {1, 1, 1}
        };

        RowResult result = busiestRow(grid);
        System.out.println("Grid:");
        for (int[] row : grid) {
            System.out.println("  " + java.util.Arrays.toString(row));
        }
        System.out.println("Output:   " + result);
        System.out.println("Expected: Row 1, Total 7");

        // Example with tie breaking: Row 0 has sum 5, Row 1 has sum 5 -> should pick Row 0
        int[][] tieGrid = {
                {2, 3},
                {1, 4}
        };
        RowResult tieResult = busiestRow(tieGrid);
        System.out.println("\nTie-break Test (Both sum to 5):");
        System.out.println("Output:   " + tieResult + " (Expected: Row 0, Total 5)");

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    int r = scanner.nextInt();
                    int c = scanner.nextInt();
                    int[][] inputGrid = new int[r][c];
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            inputGrid[i][j] = scanner.nextInt();
                        }
                    }
                    System.out.println(busiestRow(inputGrid));
                }
                scanner.close();
            }
        } catch (Exception ignored) {
        }
    }
}
