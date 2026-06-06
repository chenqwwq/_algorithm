package top.chenqwwq.leetcode.contest.weekly._352._3;

import java.util.TreeMap;

/**
 * @author chenqwwq
 * @date 2023/7/2
 **/
public class Solution {

    public long continuousSubarrays(int[] nums) {
        // 维护左右端点,保证其内的元素相差不超过2
        final int n = nums.length;
        // val -> cnt
        TreeMap<Integer, Integer> map = new TreeMap<>();
        long ans = 0;

        for (int l = 0, r = 0; r < n; r++) {
            // 计数+1
            map.merge(nums[r], 1, Integer::sum);
            while (map.lastKey() - map.firstKey() > 2) {
                final int key = nums[l++];
                if (map.get(key) == 1) map.remove(key);
                else map.merge(key, -1, Integer::sum);
            }
            ans += (r - l + 1);
        }
        return ans;
    }
}