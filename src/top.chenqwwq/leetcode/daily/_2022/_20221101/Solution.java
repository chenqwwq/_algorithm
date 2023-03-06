package top.chenqwwq.leetcode.daily._2022._20221101;

/**
 * @author chenqwwq
 * @date 2022/11/1
 **/
public class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        final int n = word1.length, m = word2.length;
        int i = 0, j = 0;
        int q = 0, p = 0;
        while (i < n && j < m) {
            while (q < word1[i].length() && p < word2[j].length()) {
                if (word1[i].charAt(q) != word2[j].charAt(p)) return false;
                q++;
                p++;
            }
            if (q >= word1[i].length()) {
                q = 0;
                i++;
            }
            if (p >= word2[j].length()) {
                j++;
                p = 0;
            }
        }
        return i == n && j == m && q == 0 && p == 0;
    }
}