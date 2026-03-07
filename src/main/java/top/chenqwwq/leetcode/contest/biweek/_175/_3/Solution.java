package top.chenqwwq.leetcode.contest.biweek._175._3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2026/2/7
 **/
public class Solution {
    public int longestSubsequence(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            List<Integer> l = new ArrayList<>();
            for (int num : nums) {
                if ((num >> i & 1) != 0) l.add(num);
            }
            ans = Math.max(ans, getLIS(l));
        }
        return ans;
    }

    private int getLIS(List<Integer> list) {
        int[] dp = new int[list.size()];
        int len = 0;
        for (int num : list) {
            int i = 0, j = len;
            while (i < j) {
                int mid = i + j >> 1;
                if (dp[mid] < num) i = mid + 1;
                else j = mid;
            }
            dp[i] = num;
            if (i == len) len++;
        }
        return len;
    }
}