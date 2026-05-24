package top.chenqwwq.leetcode.contest.weekly._494._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/3/22
 **/
public class Solution {

    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);
        return ua(nums1, 1) || ua(nums1, 0);
    }

    final int inf = 0x3f3f3f3f;

    public boolean ua(int[] nums1, int flag) {      // flag = 1 表示奇数,0 表示偶数
        int[] ms = new int[2];
        Arrays.fill(ms, inf);

        for (int j : nums1) {
            final int io = j & 1;
            ms[io] = Math.min(ms[io], j);
            if (io == flag) continue;
            if (ms[1] == inf || j - ms[1] < 1) return false;
        }
        return true;
    }
}