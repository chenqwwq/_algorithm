package top.chenqwwq.leetcode.biweek._30._2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 5445. 子数组和排序后的区间和 显示英文描述
 * 题目难度Medium
 * 给你一个数组 nums ，它包含 n 个正整数。你需要计算所有非空连续子数组的和，并将它们按升序排序，得到一个新的包含 n * (n + 1) / 2 个数字的数组。
 * <p>
 * 请你返回在新数组中下标为 left 到 right （下标从 1 开始）的所有数字和（包括左右端点）。由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^3
 * nums.length == n
 * 1 <= nums[i] <= 100
 * 1 <= left <= right <= n * (n + 1) / 2
 *
 * @author chen
 * @date 2020/7/11 下午10:50
 */
public class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        // 一时间没有好的思路
        // 采用前缀和求所有的可能
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        // 以i为起点的前缀和
        for (int i = 1; i < nums.length; i++) {
            int pre = nums[i - 1];
            for (int j = i; j < nums.length; j++) {
                pre += nums[j];
                list.add(pre);
            }
        }

        list.sort(Comparator.naturalOrder());


        int res = 0;
        for (int i = left - 1; i < right; i++) {
            res += list.get(i);
        }

        return res;

    }
}
