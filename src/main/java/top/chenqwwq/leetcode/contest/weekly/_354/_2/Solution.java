package top.chenqwwq.leetcode.contest.weekly._354._2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenqwwq
 * @date 2023/7/16
 **/
public class Solution {

    private static final int MAXN = (int) 1e5 + 1;

    public int maximumBeauty(int[] nums, int k) {
        int[] sum = new int[4 * MAXN];
        for (int num : nums) {
            int l = num - k + MAXN, r = num + k + MAXN;
            sum[l] += 1;
            sum[r + 1] -= 1;
        }
        int cur = 0, ans = 0;
        for (int j : sum) {
            ans = Math.max(ans, cur += j);
        }
        return ans;
    }
}