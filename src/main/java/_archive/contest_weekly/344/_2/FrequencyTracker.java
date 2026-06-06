package top.chenqwwq.leetcode.contest.weekly._344._2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author 沽酒
 * @since 2023/05/09
 */
public class FrequencyTracker {

    Map<Integer, Integer> num2Cnt, cnt2Cnt;

    public FrequencyTracker() {
        num2Cnt = new HashMap<>();
        cnt2Cnt = new HashMap<>();
    }

    public void add(int number) {
        final Integer now = num2Cnt.merge(number, 1, Integer::sum);
        cnt2Cnt.merge(now, 1, Integer::sum);
        cnt2Cnt.computeIfPresent(now - 1, (k, v) -> v == 1 ? null : v - 1);
    }

    public void deleteOne(int number) {
        if (!num2Cnt.containsKey(number)) return;
        final Integer cnt = num2Cnt.get(number);
        if (cnt == 1) num2Cnt.remove(number);
        else {
            num2Cnt.put(number, cnt - 1);
            cnt2Cnt.merge(cnt - 1, 1, Integer::sum);
        }

        cnt2Cnt.computeIfPresent(cnt, (k, v) -> v == 1 ? null : v - 1);

    }

    public boolean hasFrequency(int frequency) {
        return cnt2Cnt.getOrDefault(frequency, 0) > 0;
    }
}