package top.chenqwwq.leetcode.archive.$20200418.lcof;

/**
 * 面试题03. 数组中重复的数字
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 *
 * @author chen
 * @date 2020/3/6 下午3:08
 */
public class $03 {
    class Solution {
        public int findRepeatNumber(int[] nums) {
            // hash数组判断是否存在
//            boolean[] hash = new boolean[nums.length];
//            for (int i : nums){
//                if(hash[i]){
//                    return i;
//                }
//                hash[i] = true;
//            }
//            return -1;

            // 不需要额外空间的单个数组
            // 每次遍历都将元素交换到指定的位置
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                // nums[i]在正确的位置上
                if (i == temp) {
                    continue;
                }

                // 否则交换nums[i]到nums[nums[i]]上
                if (temp == nums[temp]) {
                    return nums[i];
                }
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }

            return -1;
        }
    }
}
