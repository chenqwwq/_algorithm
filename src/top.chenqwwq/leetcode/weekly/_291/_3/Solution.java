package top.chenqwwq.leetcode.weekly._291._3;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/5/1
 **/
public class Solution {
    private Set<String> vis = new HashSet<>();

    public int countDistinct(int[] nums, int k, int p) {
        final int n = nums.length;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = (i > 0 ? pre[i - 1] : 0) + (nums[i] % p == 0 ? 1 : 0);
        }
        // 1 1 1 2 3

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int cnt = pre[j] - (i > 0 ? pre[i - 1] : 0);
                if (cnt <= k) {
                    StringBuilder sb = new StringBuilder();
                    for (int q = i; q <= j; q++) {
                        sb.append(nums[q]).append(",");
                    }
                    vis.add(sb.toString());
                }
            }
        }
        return vis.size();
    }
}