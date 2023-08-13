package top.chenqwwq.leetcode.contest.weekly._358._3;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author chenqwwq
 * @date 2023/8/13
 **/
public class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        final int n = nums.size();
        if (n == 0 || n < x) return 0;

        TreeSet<Integer> set = new TreeSet<>();
        int ans = Integer.MAX_VALUE;
        for (int i = x; i < n; i++) {
            set.add(nums.get(i - x));
            final Integer num = nums.get(i);
            if (set.contains(num)) return 0;
            final Integer n1 = set.higher(num);
            if (n1 != null) ans = Math.min(ans, Math.abs(num - n1));
            final Integer n2 = set.lower(num);
            if (n2 != null) ans = Math.min(ans, Math.abs(num - n2));
        }
        return ans;
    }
}