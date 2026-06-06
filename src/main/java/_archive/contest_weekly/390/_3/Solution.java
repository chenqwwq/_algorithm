package top.chenqwwq.leetcode.contest.weekly._390._3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author chenqwwq
 * @date 2024/3/24
 **/
public class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        final int n = freq.length;
        final TreeMap<Long, Integer> cnt2Num = new TreeMap<>(Collections.reverseOrder());
        cnt2Num.put(0L, 1000000);
        final Map<Integer, Long> num2Cnt = new HashMap<>();

        final long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            final int num = nums[i];
            long a = num2Cnt.getOrDefault(num, 0L);
            long b = a + freq[i];
            cnt2Num.compute(a, (k, v) -> v == 1 ? null : v - 1);
            cnt2Num.compute(b, (k, v) -> v == null ? 1 : v + 1);
            num2Cnt.put(num, b);
            ans[i] = cnt2Num.firstKey();
        }
        return ans;
    }
}