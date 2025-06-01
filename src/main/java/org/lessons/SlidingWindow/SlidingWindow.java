package org.lessons.SlidingWindow;

import java.util.HashMap;

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

// 2
class DynamicWindow {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the symbol has already been encountered and its index is in the current window
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                // Moving the left border of the window
                left = charIndexMap.get(currentChar) + 1;
            }

            // Updating the index of the current character
            charIndexMap.put(currentChar, right);

            // Updating the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Length of the longest substring without repetitions: " + lengthOfLongestSubstring(s));
    }
}