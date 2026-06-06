package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * @author chen
 * @description 打家劫舍2 - 198成环
 * @email chenbxxx@gmail.com
 * @date 19-3-3
 */
public class LeetCode213 {
    public static void main(String[] args) {
        System.out.println(new LeetCode213().new Solution().rob(new int[]{1, 2, 3, 1}));
    }

    class Solution {
        public int rob(int[] nums) {
            /**
             * 0 - length-2 或者 1 - length - 1
             */
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            return Math.max(handle(nums, 0, nums.length - 2), handle(nums, 1, nums.length - 1));
        }

        private int handle(int[] num, int start, int end) {
            int[] dp = new int[end - start + 2];
            dp[0] = 0;
            dp[1] = num[start];
            dp[2] = num[start + 1];

            for (int i = 3; i <= end - start + 1; i++) {
                dp[i] = Math.max(num[start + i - 1] + dp[i - 2], num[start + i - 1] + dp[i - 3]);
            }
            return Math.max(dp[end - start + 1], dp[end - start]);
        }
    }
}
