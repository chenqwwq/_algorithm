package top.chenqwwq.leetcode.weekly._294._3;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/5/22
 **/
public class Solution {
    public int minimumLines(int[][] nums) {
        final int n = nums.length;
        if (n == 1) {
            return 0;
        }
        Arrays.sort(nums, Comparator.comparingInt(a -> a[0]));
        int ans = 1;
        for (int i = 0; i < n - 2; i++) {
            if (!check(nums[i], nums[i + 1], nums[i + 2])) {
                ans++;
            }
        }
        return ans;
    }

    public boolean check(int[] p1, int[] p2, int[] p3) {
        return (p3[1] - p1[1]) * (p2[0] - p1[0]) - (p2[1] - p1[1]) * (p3[0] - p1[0]) == 0;
    }
}