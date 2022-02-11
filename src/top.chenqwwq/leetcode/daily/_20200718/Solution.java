package top.chenqwwq.leetcode.daily._20200718;

/**
 * 97. 交错字符串
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * @author chen
 * @date 2020/7/18 下午2:31
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(1 ^ 10);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        // 输入都不为空
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        final char[] c1 = s1.toCharArray();
        final char[] c2 = s2.toCharArray();
        final char[] c3 = s3.toCharArray();

        // dp[i][j]表示s1中i个字符，s2中j个字符能否交错组成s3中的前i+j
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && c3[i - 1] == c1[i - 1];
        }
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j - 1] && c3[j - 1] == c2[j - 1];
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int idx3 = i + j - 1;
                dp[i][j] = (dp[i - 1][j] && c1[i - 1] == c3[idx3]) || (dp[i][j - 1] && c2[j - 1] == c3[idx3]);
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
