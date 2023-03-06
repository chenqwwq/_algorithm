package top.chenqwwq.leetcode.daily._2022._20220505;

/**
 * @author chenqwwq
 * @date 2022/5/5
 **/
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        final int n = nums.length;

        int l = 0, r = 0, ans = 0;
        long res = 1;
        while (r < n) {
            res *= nums[r++];
            while (l < r && res >= k) {
                res /= nums[l++];
            }
            ans += (r - l);
        }
        return ans;
    }
}