package top.chenqwwq.leetcode.daily._20200613;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 *
 * @author chen
 * @date 2020/6/13 下午1:54
 */
public class Solution {
    public int climbStairs(int n) {
        // DP的入门题
        if (n <= 2) {
            return n;
        }
        int l1 = 1, l2 = 2;
        for (int i = 3; i <= n; i++) {
            // 可以从前一级台阶或者前两级台阶爬到这里
            int t = l1 + l2;
            l1 = l2;
            l2 = t;
        }
        return l2;
    }
}