package top.chenqwwq.leetcode.contest.weekly._419._1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenqwwq
 * @date 2024/10/13
 **/
public class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        final int n = nums.length;
        final int[] mc = new int[51];
        final int[] ans = new int[n - k + 1];
        for (int l = 0, r = 0; r < n; r++) {
            mc[nums[r]]++;
            while (r - l + 1 > k) {
                mc[nums[l++]]--;
            }
            if (r >= k - 1) {
                final int[][] t = new int[51][2];
                for(int i = 0;i < 51;i++){
                    t[i] = new int[]{i, mc[i]};
                }
                Arrays.sort(t, ((Comparator<int[]>) (o1, o2) -> Integer.compare(o2[1], o1[1])).thenComparing((o1, o2) -> Integer.compare(o2[0],o1[0])));
                for (int i = 0; i < x; i++) {
                    ans[r-k+1] += t[i][0] * t[i][1];
                }
            }
        }
        return ans;
    }
}