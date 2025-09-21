package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 152. Maximum product subarray 最大乘积子序列
 *
 * @author chen
 * @date 19-5-26
 */
public class LeetCode152 {
    public static void main(String[] args) {
        System.out.println(new LeetCode152().new Solution().maxProduct(new int[]{2, -5, -2, -4, 3}));
    }

    class Solution {
        public int maxProduct(int[] nums) {
            // ===========================================================
            // 和最大和子序列不同,乘积在遇到负数时最大,最小值会互换
            // DP公式:
            // maxDp[i] = Math.max(nums[i],maxDp[i - 1] * nums[i],minDp[i - 1] * nums[i])
            // minDp[i] = Math.min(nums[i],maxDp[i - 1] * nums[i],minDp[i - 1] * nums[i])
            //
            // 只需要求max,min不需要数组
            // ===========================================================
            if (nums == null || nums.length == 0) {
                return 0;
            }
//            int[] maxDp = new int[nums.length];
//            int[] minDp = new int[nums.length];
//
//            int max = maxDp[0] = minDp[0] = nums[0];
//
//            for (int i = 1; i < nums.length; i++) {
//                maxDp[i] = Math.max(nums[i],Math.max(maxDp[i - 1] * nums[i],minDp[i - 1] * nums[i]));
//                minDp[i] = Math.min(nums[i],Math.max(maxDp[i - 1] * nums[i],minDp[i - 1] * nums[i]));
//
//                max = Math.max(maxDp[i],max);
//            }
//
//            return max;

            int max, min, ret;
            max = min = ret = nums[0];

            for (int i = 1; i < nums.length; i++) {
                int temp = max;
                max = Math.max(nums[i], Math.max(temp * nums[i], min * nums[i]));
                min = Math.min(nums[i], Math.min(temp * nums[i], min * nums[i]));

                ret = Math.max(max, ret);
            }
            return ret;
        }
    }
}
