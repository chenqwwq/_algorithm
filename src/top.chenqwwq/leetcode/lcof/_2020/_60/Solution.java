package top.chenqwwq.leetcode.lcof._2020._60;

/**
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。*
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 11
 *
 * @author chen
 * @date 2020-07-03
 **/
public class Solution {
    public double[] twoSum(int n) {
        // 动态规划处理
        // 因为n最大为11，所以最大和为66

        // dp[i][j] 为第i次掷骰子，掷出j点的次数
        int[][] dp = new int[n][n * 6];
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }

        // i表示第几次掷筛子
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < (i + 1) * 6; j++) {
                for (int point = 1; point <= 6; point++) {
                    if (j - point < 1) {
                        continue;
                    }
                    // i-1表示之前一次
                    // 当前point点 希望j点 所有之前需要j -point点
                    dp[i][j - 1] += dp[i - 1][j - point];
                }
            }
        }

        // 总数是6^n种情况
        double total = Math.pow(6, n);
        double[] res = new double[6 * n];
        for (int i = n - 1, idx = 0; i < n * 6; i++, idx++) {
            res[idx] = dp[n - 1][i] / total;
        }

        return res;
    }
}
