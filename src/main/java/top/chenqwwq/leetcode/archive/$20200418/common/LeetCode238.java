package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 238. Product of Array Except Self
 *
 * @author chen
 * @date 19-7-2 上午7:34
 */
public class LeetCode238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            // 开辟两个数组,从左到右和从右到左分别乘一次
            if (nums == null || nums.length == 0) {
                return new int[]{};
            }
            int length = nums.length;
            // 记录从右往左到i的乘积
            int[] right = new int[length];
            right[length - 1] = nums[length - 1];
            for (int i = length - 2; i > 0; i--) {
                right[i] = nums[i] * right[i + 1];
            }

            int[] left = new int[length];
            left[0] = nums[0];
            for (int i = 1; i < length; i++) {
                left[i] = nums[i] * left[i - 1];
            }

            int[] res = new int[length];

            res[0] = right[1];
            res[length - 1] = left[length - 2];
            for (int i = 1; i < length - 1; i++) {
                res[i] = right[i + 1] * left[i - 1];
            }
            return res;
        }
    }
}

