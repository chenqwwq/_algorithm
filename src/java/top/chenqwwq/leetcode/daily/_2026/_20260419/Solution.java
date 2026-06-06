package top.chenqwwq.leetcode.daily._2026._20260419;

import java.util.TreeMap;

/**
 * @author chenqwwq
 * @date 2026/4/19
 **/
public class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        final int n = nums1.length, m = nums2.length;
        TreeMap<Integer, Integer> set = new TreeMap<>();
        for (int i = m - 1; i >= 0; i--) {
            if (!set.containsKey(nums2[i])) {
                set.put(nums2[i], i);
            }
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            final Integer higher = set.ceilingKey(nums1[i]);
            if (higher == null) continue;
            final Integer idx = set.get(higher);
            if (idx < i) continue;
            ans = Math.max(ans, idx - i);
        }
        return ans;
    }
}