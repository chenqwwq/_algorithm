package top.chenqwwq.leetcode.lcof2._104;


/**
 * @author chenbingxin
 * @date 2022/1/3
 **/
public class Solution {

    public int combinationSum4(int[] nums, int target) {
        if (target < 1) {
            return 0;
        }

        final int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num > i) {
                    continue;
                }
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
