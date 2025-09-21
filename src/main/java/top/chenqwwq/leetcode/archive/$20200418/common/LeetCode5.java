package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 5. Longest Palindromic Substring 最长回文子串
 *
 * @author chen
 * @date 19-5-26
 */
public class LeetCode5 {
    public static void main(String[] args) {
        System.out.println(new LeetCode5().new Solution().longestPalindrome("abacab"));
        System.out.println("babad".substring(1, 5));
    }

    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            // 二维数组
            // dp[i][j] 表示j到i的回文子串长度
            int[][] dp = new int[s.length()][s.length()];

            // 一位数表示长度为1的回文
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = 1;
            }

            int max = 1;
            // 从左上角开始遍历左下方区域
            for (int i = 1; i < s.length(); i++) {
                for (int j = i - 1; j >= 0; j--) {
                    final boolean b = s.charAt(i) == s.charAt(j);
                    if (i - j <= 2) {
                        dp[i][j] = b ? i - j + 1 : dp[i][j + 1];
                    } else {
                        dp[i][j] = b && i - j - 1 == dp[i - 1][j + 1] ? dp[i - 1][j + 1] + 2 : dp[i][j + 1];
                    }
                }

                max = Math.max(max, dp[i][0]);
            }

            System.out.println("max :" + max);

            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j >= 0; j--) {
                    if (dp[i][j] == max) {
                        System.out.printf("i : %d,j: % d \n", i, j);
                        return s.substring(j, i + 1);
                    }
                }
            }
            return "";
        }
    }
}
