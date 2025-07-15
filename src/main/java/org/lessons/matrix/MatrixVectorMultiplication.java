package org.lessons.matrix;

public class MatrixVectorMultiplication {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[] vector = {2, 1, 0};
        int[] result = multiplyMatrixByVector(matrix, vector);

        System.out.println("Результат умножения матрицы на вектор:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] multiplyMatrixByVector(int[][] matrix, int[] vector) {
        if (matrix[0].length != vector.length) {
            throw new IllegalArgumentException("Несовместимые размеры матрицы и вектора");
        }

        int[] result = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return result;
    }
}