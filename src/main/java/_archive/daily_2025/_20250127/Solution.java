package top.chenqwwq.leetcode.daily._2025._20250127;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2025/1/29
 **/
public class Solution {

    int INF = 0x3f3f3f3f;


    public int jump(int[] nums) {
        final int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, INF);
        memo[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                int idx = i + j;
                if(idx < n) memo[idx] = Math.min(memo[idx],memo[i] + 1);
            }
        }
        return memo[n-1];
    }
}