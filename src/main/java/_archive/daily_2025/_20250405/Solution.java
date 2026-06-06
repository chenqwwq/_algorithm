package top.chenqwwq.leetcode.daily._2025._20250405;

/**
 * @author chenqwwq
 * @date 2025/4/5
 **/
public class Solution {
    int ans = 0;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return ans;
    }

    public void dfs(int[] nums, int cur, int idx) {
        if (idx >= nums.length) {
            ans += cur;
            return;
        }
        // 包含
        dfs(nums, cur ^ nums[idx], idx + 1);
        // 不包含
        dfs(nums, cur, idx + 1);
    }
}