package top.chenqwwq.leetcode.archive.lcof2._101;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenbingxin
 * @date 2022/1/2
 **/
public class Solution {
    public boolean canPartition(int[] nums) {
        cache = new HashMap<>();
        final int n = nums.length;
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return nums[0] == nums[1];
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        final int target = sum >> 1;
//        boolean[] dp = new boolean[target + 1];
//        dp[0] = true;
//        for (int num : nums) {
//            for (int i = target; i >= num; i--) {
//                dp[i] |= dp[i - num];
//            }
//        }
//        return dp[target];
        for (int i = 0; i < n; i++) {
            cache.put(i, new HashMap<>());
        }

        return dfs(nums, 0, target);
    }

    Map<Integer, Map<Integer, Boolean>> cache;

    public boolean dfs(int[] nums, int i, int target) {
        if (target == 0) {
            return true;
        }
        if (i >= nums.length || target < 0) {
            return false;
        }

        final Map<Integer, Boolean> innerCache = cache.get(i);
        if (innerCache.containsKey(target)) {
            return innerCache.get(target);
        }

        final boolean dfs = dfs(nums, i + 1, target) || dfs(nums, i + 1, target - nums[i]);
        innerCache.put(target,dfs);
        return dfs;
    }
}