package top.chenqwwq.leetcode.daily._20200714;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * @author chen
 * @date 2020-07-14
 **/
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }

        final int n = triangle.size();
        if (n == 1) {
            return triangle.get(0).get(0);
        }

        int[] dp = new int[n];
        final List<Integer> bottom = triangle.get(n - 1);
        for (int i = 0; i < n; i++) {
            dp[i] = bottom.get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            final List<Integer> curr = triangle.get(i);
            for (int j = 0; j < curr.size(); j++) {
                dp[j] = curr.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}