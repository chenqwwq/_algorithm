package top.chenqwwq.leetcode.biweek._30._3;

import java.util.Arrays;

/**
 * 5446. 三次操作后最大值与最小值的最小差 显示英文描述
 * 题目难度Medium
 * 给你一个数组 nums ，每次操作你可以选择 nums 中的任意一个数字并将它改成任意值。
 * <p>
 * 请你返回三次操作后， nums 中最大值与最小值的差的最小值。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 *
 * @author chen
 * @date 2020/7/11 下午11:39
 */
public class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 3) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        // 全部排序之后从前往后或者从后往前选取三个
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (i + j != 3) {
                    continue;
                }
                ans = Math.min(ans, nums[n - 1 - j] - nums[i]);
            }
        }
        return ans;
    }
}