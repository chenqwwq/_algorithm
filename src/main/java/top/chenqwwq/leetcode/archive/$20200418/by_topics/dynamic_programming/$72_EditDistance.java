package top.chenqwwq.leetcode.archive.$20200418.by_topics.dynamic_programming;

/**
 * 72. 编辑距离
 * <p>
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * @author chen
 * @date 2019/12/21 下午3:50
 */
public class $72_EditDistance {
    class Solution {
        public int minDistance(String word1, String word2) {
            // word1为x轴 word2为y轴
            int[][] dp = new int[word2.length() + 1][word1.length() + 1];

            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = i;
            }

            for (int i = 0; i < dp[0].length; i++) {
                dp[0][i] = i;
            }

            final char[] chars2 = word2.toCharArray();
            final char[] chars1 = word1.toCharArray();

            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (chars1[j - 1] == chars2[i - 1]) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    }
                }
            }

            return dp[word2.length()][word1.length()];
        }
    }
}



















