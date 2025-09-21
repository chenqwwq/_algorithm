package top.chenqwwq.leetcode.contest.weekly._349._2;

/**
 * @author chenqwwq
 * @date 2023/6/11
 **/
public class Solution {
    public String smallestString(String s) {
        final int n = s.length();
        if (n <= 0) return s;
        StringBuilder sb = new StringBuilder(s);
        int l = -1, r = -1;
        for (int i = 0; i < n; i++) {
            // 找第一个不等于0的
            if (sb.charAt(i) != 'a' && l == -1) l = i;
            if (sb.charAt(i) == 'a' && l != -1) {
                r = i;
                break;
            }
        }
        if (l == -1) {
            sb.setCharAt(n - 1, 'z');
            return sb.toString();
        }
        if (r == -1) r = n;
        while (l < r) {
            sb.setCharAt(l, (char) (sb.charAt(l) - 1));
            l++;
        }
        return sb.toString();
    }
}