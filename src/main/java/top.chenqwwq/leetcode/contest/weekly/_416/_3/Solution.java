package top.chenqwwq.leetcode.contest.weekly._416._3;

/**
 * @author chenqwwq
 * @date 2024/9/22
 **/
public class Solution {

    public long validSubstringCount(String word1, String word2) {
        final int n = word1.length(), m = word2.length();
        // 其中获取其中一个hash
        final int[] h1 = new int[26], h2 = new int[26];
        for (int i = 0; i < m; i++) h1[word2.charAt(i) - 'a']++;

        long ans = 0;
        // 枚举末尾
        // j 表示包含的最后前缀,j -> i 肯定满足要求
        for (int i = 0, j = 0; i < n; i++) {
            h2[word1.charAt(i) - 'a']++;
            // 当前已经包含所有
            if (check(h1, h2)) {
                // 开始收缩窗口
                while (check(h1, h2)) {
                    h2[word1.charAt(j++) - 'a']--;
                }
                h2[word1.charAt(--j) - 'a']++;
                ans += j + 1;
            }
        }
        return ans;
    }

    public boolean check(int[] h1, int[] h2) {
        for (int i = 0; i < 26; i++) {
            if (h1[i] > h2[i]) return false;
        }
        return true;
    }
}