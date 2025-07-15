package org.lessons.matrix;

public class MatrixDeterminant {
    public static void main(String[] args) {
        int[][] matrix = {
                {4, 7},
                {2, 6}
        };

        int determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        System.out.println("Определитель матрицы:");
        printMatrix(matrix);
        System.out.println("Равен: " + determinant);
    }

    public static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
