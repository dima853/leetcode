package org.lessons.arrays;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Generates Pascal's Triangle up to the specified number of rows.
     *
     * @param numRows The number of rows to generate in Pascal's Triangle.
     * @return A list of lists representing Pascal's Triangle.  Each inner list
     *         represents a row in the triangle.
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) {
            return triangle; // Return an empty list if numRows is invalid.
        }

        // Iterate through each row of the triangle
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            // The first and last element of each row is always 1
            row.add(1);

            // For rows beyond the first, calculate the intermediate elements
            if (i > 0) {
                List<Integer> prevRow = triangle.get(i - 1);
                for (int j = 1; j < i; j++) {
                    // Each element is the sum of the two elements directly above it
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }
                row.add(1); // Add the last 1 to the row.
            }

            triangle.add(row); // Add the newly created row to the triangle.
        }

        return triangle;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int numRows = 5;
        List<List<Integer>> pascalTriangle = sol.generate(numRows);

        // Print Pascal's Triangle (optional for testing)
        for (List<Integer> row : pascalTriangle) {
            System.out.println(row);
        }
    }
}