package top.chenqwwq.leetcode.topic.math._268;

/**
 * 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * <p>
 *
 * @author chen
 * @date 2020/6/27 下午9:59
 */
public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int expect = nums.length * (nums.length + 1) / 2;
        for (int num : nums) {
            expect -= num;
        }
        return expect;
    }
}
