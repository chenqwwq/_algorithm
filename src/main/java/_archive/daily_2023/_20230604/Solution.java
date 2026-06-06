package top.chenqwwq.leetcode.daily._2023._20230604;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2023/6/4
 **/
public class Solution {
    public int distinctAverages(int[] nums) {
        final int n = nums.length;
        if (n <= 1) return n;
        Arrays.sort(nums);
        int l = 0, r = n - 1;
        Set<Double> vis = new HashSet<>();
        while (l <= r) {
            vis.add((nums[l++] + nums[r--]) / 2d);
        }
        return vis.size();
    }
}