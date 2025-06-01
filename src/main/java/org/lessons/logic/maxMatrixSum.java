package org.lessons.logic;

public class maxMatrixSum {
    int maxMatrix(int[][] matrix) {
        int sum = 0, negativeCount = 0, min = 1000_000_000;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int num = matrix[i][j];
                sum += Math.abs(num);
                if (num < 0) {
                    negativeCount++;
                }
                min = Math.min(min, Math.abs(num));
            }
        }
        if (negativeCount % 2 == 0) {
            return sum;
        } else {
            return sum - 2 * min;
        }
    }
}
