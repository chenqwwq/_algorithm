package top.chenqwwq.leetcode.contest.weekly._392._1;

/**
 * @author chenqwwq
 * @date 2024/4/7
 **/
public class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        final int n = nums.length;
        if (n < 2) return n;
        int ans = 1, cur = 1;
        int flag = 0; // 0表示不确定,1 表示递增,-1 表示递减
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, cur);
            if (nums[i] > nums[i - 1] && flag >= 0) {
                flag = 1;
                cur++;
            } else if (nums[i] < nums[i - 1] && flag <= 0) {
                flag = -1;
                cur++;
            } else if (nums[i] == nums[i - 1]) {
                flag = 0;
                cur = 1;
            } else if (nums[i] > nums[i - 1]) {
                flag = 1;
                cur = 2;
            } else if (nums[i] < nums[i - 1]) {
                flag = -1;
                cur = 2;
            }
        }
        return Math.max(ans, cur);
    }

    public static void main(String[] args) {
        new Solution().longestMonotonicSubarray(new int[]{1,5,10,3});
    }
}