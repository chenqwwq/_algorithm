package top.chenqwwq.leetcode.daily._20221125;

/**
 * @author chenqwwq
 * @date 2022/11/25
 **/
public class Solution {
    public int expressiveWords(String s, String[] words) {
        int cnt = 0;
        for (String word : words) {
            if (judge(s, word)) cnt++;
        }
        return cnt;
    }

    boolean judge(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s1.charAt(i) != s2.charAt(j)) return false;
            int c1 = 1;
            while (i + 1 < n && s1.charAt(i + 1) == s1.charAt(i)) {
                c1++;i++;
            }
            int c2 = 1;
            while (j + 1 < m && s2.charAt(j + 1) == s2.charAt(j)) {
                c2++;j++;
            }
            if (c1 < c2 || (c1 > c2 && c1 < 3)) return false;
            i++;j++;
        }
        return i == n && j == m;
    }
}