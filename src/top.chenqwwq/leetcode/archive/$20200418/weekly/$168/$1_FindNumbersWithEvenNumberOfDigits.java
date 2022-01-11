package top.chenqwwq.leetcode.archive.$20200418.weekly.$168;

/**
 * 统计位数为偶数的数字
 * <p>
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [12,345,2,6,7896]
 * 输出：2
 * 解释：
 * 12 是 2 位数字（位数为偶数）
 * 345 是 3 位数字（位数为奇数）
 * 2 是 1 位数字（位数为奇数）
 * 6 是 1 位数字 位数为奇数）
 * 7896 是 4 位数字（位数为偶数）
 * 因此只有 12 和 7896 是位数为偶数的数字
 * 示例 2：
 * <p>
 * 输入：nums = [555,901,482,1771]
 * 输出：1
 * 解释：
 * 只有 1771 是位数为偶数的数字。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 *
 * @author chen
 * @date 2019/12/22 下午12:14
 */
public class $1_FindNumbersWithEvenNumberOfDigits {
    class Solution {
        public int findNumbers(int[] nums) {
            int res = 0;
            for (int num : nums) {
                int i = 0, divisor = 1;
                while (num / divisor != 0) {
                    divisor *= 10;
                    i++;
                }
                if ((i & 1) == 0) {
                    res++;
                }
            }

            return res;
        }
    }
}
