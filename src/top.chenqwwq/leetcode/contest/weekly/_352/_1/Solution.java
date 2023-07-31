package top.chenqwwq.leetcode.contest.weekly._352._1;

/**
 * @author chenqwwq
 * @date 2023/7/2
 **/
public class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        final int n = nums.length;
        int ans = 0;
        for (int l = 0; l < n; ) {
            if (nums[l] % 2 != 0 || nums[l] > threshold) {
                l++;
                continue;
            }
            int r = l + 1;
            while (r < n) {
                if (nums[r] > threshold || nums[r] % 2 == nums[r - 1] % 2) break;
                r++;
            }
            ans = Math.max(r - l, ans);
            l = r;
        }
        return ans;
    }
}