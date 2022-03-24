package other.intervalIntersection;

import java.util.Arrays;
import java.util.Stack;

/**
 * Заданы n временных интервалы (int a, int b) - время заезда и выезда гостя в гостиницу
 * гости приезжают по 1му и заселяются в одноместные номера
 * Выведите минимальное количество номеров, в которых можно разместить гостей
 * Если один гость уезжает, а другой заезжает в тот же день, то считаем что они смогут разместиться в 1 номере друг за другом
 * <p>
 * пример
 * ввод
 * 5
 * 1 10
 * 11 12
 * 2 5
 * 3 5
 * 4 7
 * вывод
 * 4
 */
public class IntervalIntersection {
    private Pair[] intervals;

    public IntervalIntersection(Pair[] intervals) {
        this.intervals = intervals;
    }

    public int calculateIntersection() {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }
        //int[] allDates = new int[2 * n];
        int[] startDates = new int[n];
        int[] endDates = new int[n];

        for (int i = 0; i < n; i++) {
            //allDates[2 * i] = intervals[i].start;
            //allDates[2 * i + 1] = intervals[i].end;
            startDates[i] = intervals[i].start;
            endDates[i] = intervals[i].end;
        }
        Arrays.sort(startDates);
        Arrays.sort(endDates);

        int max = 1;
        int current = 1;
        int i = 1, j = 0;
        int a, b;
        while (i + j < 2 * n) {
            a = i < n ? startDates[i] : startDates[n - 1];
            b = endDates[j];
            if (a < b && i < n) {
                current++;
                i++;
            } else {//todo
                if (current > max) {
                    max = current;
                }
                current--;
                j++;
            }
        }
        return max;
    }

}
