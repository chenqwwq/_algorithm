package top.chenqwwq.leetcode.contest.weekly._489._2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chenqwwq
 * @date 2026/2/15
 **/
public class Solution {
    public int firstUniqueFreq(int[] nums) {
        // num 2 cnt
        final Map<Integer, Long> num2Cnt = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(o -> o, Collectors.counting()));

        // CNT -> cnt
        final Map<Long, Long> cnt2Cnt = new ArrayList<>(num2Cnt.values()).stream().collect(Collectors.groupingBy(o -> o, Collectors.counting()));

        for (int num : nums) {
            if (cnt2Cnt.get(num2Cnt.get(num)) == 1) return num;
        }
        return -1;
    }
}