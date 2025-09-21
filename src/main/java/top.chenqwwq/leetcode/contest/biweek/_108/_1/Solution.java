package top.chenqwwq.leetcode.contest.biweek._108._1;

/**
 * @author chenqwwq
 * @date 2023/7/8
 **/
public class Solution {

    public int alternatingSubarray(int[] nums) {
        final int n = nums.length;
        int ans = -1, cur = 1;
        while (cur < n) {
            if (nums[cur] != nums[cur - 1] + 1) {
                cur++;
                continue;
            }
            int len = 2, diff = -1;
            while (++cur < n) {
                if (nums[cur] - nums[cur - 1] != diff) break;
                len++;
                diff *= -1;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}