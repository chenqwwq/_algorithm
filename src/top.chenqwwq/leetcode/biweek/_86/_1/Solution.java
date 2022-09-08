package top.chenqwwq.leetcode.biweek._86._1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2022/9/3
 **/
public class Solution {
    public boolean findSubarrays(int[] nums) {
        final int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }
}