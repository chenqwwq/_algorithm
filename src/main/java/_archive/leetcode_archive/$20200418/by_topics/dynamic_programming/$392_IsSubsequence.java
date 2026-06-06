package top.chenqwwq.leetcode.archive.$20200418.by_topics.dynamic_programming;

import java.util.Arrays;

/**
 * 392. Is Subsequence
 * Easy
 * <p>
 * Given a string s and a string t, check if s is subsequence of t.
 * <p>
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * Return true.
 * <p>
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * * <p>
 * Return false.
 * <p>
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 * <p>
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test cases.
 *
 * @author bingxin.chen
 * @date 2019/9/6 12:11
 */
public class $392_IsSubsequence {
    class Solution {
        /**
         * 为了练习DP,强行用的,效率并不高
         */
        public boolean isSubsequence(String s, String t) {
            // 记录基础数据
            final int length = t.length(),
                    sLength = s.length();
            if (sLength > length) {
                return false;
            }

            final char[] tCha = t.toCharArray(),
                    sCha = s.toCharArray();

            // dp[n]表示s的某个字符在t.subString(0,n+1)中是否是子串
            // dp数组可以复用,针对于s的每个字母
            // 对于sCha[i],p[n] = dp[n] && sCha[i] == tCha[n]
            boolean[][] dp = new boolean[sLength + 1][length + 1];

            // 全部填充为true
            Arrays.fill(dp[0], true);

            // 外部遍历s,内部遍历t
            for (int i = 0; i < sLength; i++) {
                for (int j = i; j < t.length(); j++) {
                    if (sCha[i] == tCha[j]) {
                        dp[i + 1][j + 1] = dp[i][j];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j];
                    }
                }
            }

            return dp[sLength][length];
        }
    }
}
