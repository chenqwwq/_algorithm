package top.chenqwwq.leetcode.weekly._294._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/5/22
 **/
public class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        final int n = capacity.length;
        int ans = 0;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        for (int i = 0; i < n && additionalRocks > 0; i++) {
            if (diff[i] <= additionalRocks) {
                additionalRocks -= diff[i];
                ans++;
            }
        }
        return ans;
    }
}