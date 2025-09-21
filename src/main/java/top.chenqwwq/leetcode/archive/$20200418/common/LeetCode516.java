package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 516. 最长回文子序列
 * 可以不连续
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * "bbbab"
 * 输出:
 * <p>
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * <p>
 * 示例 2:
 * 输入:
 * <p>
 * "cbbd"
 * 输出:
 * <p>
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 * @author bingxin.chen
 * @date 2019/8/5 12:16
 */
public class LeetCode516 {
    class Solution {
        public int longestPalindromeSubseq(String s) {
//            // 二维数组dp
            if (s == null) {
                return 0;
            }
            final int length = s.length();
            if (length <= 1) {
                return length;
            }
            // dp[i][j] 表示的是数组i->j范围内的回文长度
            int[][] dp = new int[length][length];
            final char[] chars = s.toCharArray();
            // 从右下角开始遍历半边的二维数组
            // 数组初始化全为0,所以不需要在赋值
            for (int i = length - 1; i >= 0; i--) {
                dp[i][i] = 1;
                for (int j = i + 1; j < length; j++) {
                    // 判断是否回文
                    if (chars[i] == chars[j]) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[0][length - 1];


//            // 转化为一维数组的dp问题
//            int[] dp = new int[length];
//            // 从字符串的最后一个字符开始统计
//            for (int i = length - 1;i >= 0;i--){
//                dp[i] = 1;
//
//            }
        }
    }
}
