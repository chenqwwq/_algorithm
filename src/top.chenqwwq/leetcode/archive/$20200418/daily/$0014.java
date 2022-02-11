package top.chenqwwq.leetcode.archive.$20200418.daily;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * @author chen
 * @date 2020/3/14 下午10:12
 */
public class $0014 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null) {
                return 0;
            }
            if (nums.length <= 1) {
                return nums.length;
            }

            int[] dp = new int[nums.length];
            dp[0] = 1;
            int res = 1;
            for (int i = 1; i < nums.length; i++) {
                int k = i;
                for (int j = i; j >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                dp[i] = Math.max(dp[i], 1);
                res = Math.max(res, dp[i]);
            }

            return res;
        }
    }

}
