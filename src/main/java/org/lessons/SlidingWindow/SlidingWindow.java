package org.lessons.SlidingWindow;

// 1 MaxSum
class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        System.out.println("Maximum sum of a subarray of size " + k + ": " + maxSum(arr, k));
    }
    public static int maxSum(int[] arr, int k) {
        // Validation of input data
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return 0;
        }

        // Calculate the sum of the first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // We move the window by one position and recalculate the amount
        for (int i = k; i < arr.length; i++) {
        // Add a new element and remove the leftmost element of the previous window
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}