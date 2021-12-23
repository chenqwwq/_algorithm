package top.chenqwwq.leetcode.weekly._123._3;

import java.util.*;

/**
 * @author chen
 * @date 2020/11/15
 **/
public class Solution {
    public int minOperations(int[] nums, int x) {
        // 前缀和
        int[] pa = new int[nums.length + 1];
        pa[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            pa[i + 1] = pa[i] + nums[i];
        }

        Map<Integer, Integer> m2 = new HashMap<>();
        m2.put(0, 0);
        int pre = nums[nums.length - 1];
        m2.put(pre, 1);
        for (int i = 1; i < nums.length; i++) {
            int idx = nums.length - 1 - i;
            m2.put((pre += nums[idx]), i + 1);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < pa.length && pa[i] <= x; i++) {
            int key = x - pa[i];
            if (m2.containsKey(key) && m2.get(key) <= nums.length - i) {
                int b = i + m2.get(key);
                ans = Math.min(ans, b);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{5, 2, 3, 1, 1}, 5));
    }
}