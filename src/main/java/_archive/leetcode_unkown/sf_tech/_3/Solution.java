package top.chenqwwq.leetcode.unkown.sf_tech._3;

/**
 * @author 沽酒
 * @since 2022/06/30
 */
public class Solution {
    public int findMaxCI(int[] nums) {
        final int n = nums.length;
        int ans = Math.min(1, n), cur = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                ans = Math.max(++cur, ans);
            } else {
                cur = 1;
            }
        }
        return ans;
    }
}