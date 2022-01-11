package top.chenqwwq.leetcode.lcof2._35;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenbingxin
 * @date 2021/12/31
 **/
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        final int n = timePoints.size();
        List<Integer> times = new ArrayList<>(n);
        for (String timePoint : timePoints) {
            times.add(getTime(timePoint));
        }
        times.sort(Integer::compare);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(times.get(i + 1) - times.get(i), min);
        }
        return Math.min(min, 24 * 60 + times.get(0) - times.get(n - 1));
    }

    public int getTime(String time) {
        final String[] nums = time.split(":");
        return Integer.parseInt(nums[0]) * 60 + Integer.parseInt(nums[1]);
    }
}