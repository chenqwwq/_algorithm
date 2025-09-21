package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 647. 最长连续递增序列
 * <p>
 * 题目描述
 * 评论 (81)
 * 题解(9)New
 * 提交记录
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * 注意：数组长度不会超过10000。
 *
 * @author chen
 * @date 2019/8/11 上午7:25
 */
public class LeetCode647 {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int res = 1, max = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    res++;
                } else {
                    max = Math.max(max, res);
                    res = 1;
                }
            }
            return Math.max(res, max);
        }
    }
}
