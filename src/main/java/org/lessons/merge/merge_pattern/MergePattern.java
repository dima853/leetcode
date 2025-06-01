package org.lessons.merge.merge_pattern;

import java.util.*;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {

        // 1. Проверка на null и пустой список
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        // 2. Сортировка интервалов по началу (start)
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // 3. Создаем список для хранения объединенных интервалов
        List<Interval> mergedIntervals = new LinkedList<>();

        // 4. Добавляем первый интервал в mergedIntervals
        mergedIntervals.add(intervals.get(0));

        // 5. Итерируемся по остальным интервалам
        for (int i = 1; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);
            Interval lastMergedInterval = mergedIntervals.get(mergedIntervals.size() - 1);

            // 6. Проверяем, пересекается ли текущий интервал с последним объединенным
            if (currentInterval.start <= lastMergedInterval.end) {
                // 7. Слияние интервалов
                lastMergedInterval.end = Math.max(lastMergedInterval.end, currentInterval.end);
            } else {
                // 8. Если не пересекаются, добавляем текущий интервал в mergedIntervals
                mergedIntervals.add(currentInterval);
            }
        }

        return mergedIntervals;
    }

    public static void main(String[] args) {
        // Пример использования
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        MergeIntervals merger = new MergeIntervals();
        List<Interval> merged = merger.merge(intervals);

        // Вывод результата
        for (Interval interval : merged) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
        // Вывод: [1,6] [8,10] [15,18]
    }
}