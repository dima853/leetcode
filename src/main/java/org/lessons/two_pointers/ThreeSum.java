package org.lessons.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        // 1. Создаем список для хранения результатов.
        List<List<Integer>> result = new ArrayList<>();

        // 2. Сортируем входной массив. Это необходимо для алгоритма двух указателей и исключения дубликатов.
        Arrays.sort(nums);

        // 3. Перебираем массив до предпоследнего элемента (i < nums.length - 2), так как нам нужно минимум 3 элемента.
        for (int i = 0; i < nums.length - 2; i++) {
            // 4. Пропускаем дубликаты для первого числа.  Если текущий элемент равен предыдущему, переходим к следующему.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 5. Устанавливаем два указателя: left (слева от i) и right (справа от i).
            int left = i + 1;
            int right = nums.length - 1;

            // 6. Пока левый указатель меньше правого, продолжаем поиск.
            while (left < right) {
                // 7. Вычисляем сумму трех чисел: nums[i], nums[left], nums[right].
                int sum = nums[i] + nums[left] + nums[right];

                // 8. Если сумма равна нулю, нашли тройку!
                if (sum == 0) {
                    // 9. Создаем новый список, содержащий найденные числа.
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 10. Пропускаем дубликаты для второго числа (nums[left]).
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // 11. Пропускаем дубликаты для третьего числа (nums[right]).
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 12. Сдвигаем указатели: левый - вправо, правый - влево.
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 13. Если сумма меньше нуля, значит, нужно увеличить левое число.
                    left++;
                } else {
                    // 14. Если сумма больше нуля, значит, нужно уменьшить правое число.
                    right--;
                }
            }
        }

        // 15. Возвращаем список найденных троек.
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result); // Вывод: [[-1, -1, 2], [-1, 0, 1]]
    }
}