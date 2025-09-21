package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 220. Containers duplicate III
 *
 * @author bingxin.chen
 * @date 2019 /7/9 18:10
 */
public class LeetCode220 {
    public static void main(String[] args) {
        System.out.println(new LeetCode220().new Solution().containsNearbyAlmostDuplicate(new int[]{2147483647, -2147483647}, 1, 2147483647));
    }

    /**
     * The type Solution.
     */
    class Solution {
        /**
         * 判断是否存在i,j
         * 使num[i],num[j]差的绝对值小于等于t,并且i,j绝对值小于等于k
         *
         * @param nums the nums
         * @param k    the k
         * @param t    the t
         * @return boolean
         */
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            // 最暴力的线性搜索法
            final int length = nums.length;
            for (int i = 0; i < length; i++) {
                int start = Math.max(i - k, 0);
                int end = Math.min(i + k, length - 1);
                while (start < i) {
                    // 取巧方式,转double防止溢出
                    final double abs = Math.abs((double) (nums[start] - nums[i]));
                    if (abs <= t) {
                        return true;
                    }

                    start++;
                }

                while (end < i) {
                    final double abs = Math.abs((double) (nums[i] - nums[end]));
                    if (abs <= t) {
                        return true;
                    }
                    end++;
                }
            }
            return false;
        }
    }
}
