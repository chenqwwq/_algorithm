package top.chenqwwq.leetcode.contest.weekly._318._2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/11/7
 **/
public class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        final int n = nums.length;
        Map<Integer, Integer> hash = new HashMap<>();
        long sum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
            if (i > k - 1) {
                int num = nums[i - k];
                int cnt = hash.get(num);
                if (cnt == 1) hash.remove(num);
                else hash.put(num, cnt - 1);
                sum -= num;
            }
            if (i >= k - 1 && hash.size() == k) ans = Math.max(ans, sum);
        }
        return ans;
    }
}