package top.chenqwwq.leetcode.archive.lcof2._102;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenbingxin
 * @date 2022/1/3
 **/
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int[] dp = new int[2 * sum];
        return -1;
    }

    public int tb(int[] nums, int i, int target) {
        if (i >= nums.length) {
            return target == 0 ? 1 : 0;
        }
        final String key = getKey(i, target);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        final int ans = tb(nums, i + 1, target - nums[i]) + tb(nums, i + 1, target + nums[i]);
        cache.put(key, ans);
        return ans;
    }

    Map<String, Integer> cache = new HashMap<>();

    public String getKey(int i, int target) {
        return i + "-" + target;
    }
}