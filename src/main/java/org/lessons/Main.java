package org.lessons;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] prefix = calculatePrefixSum(arr);

        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Prefix sum array: " + Arrays.toString(prefix));
    }
    public static int[] calculatePrefixSum(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        return prefix;
    }
}