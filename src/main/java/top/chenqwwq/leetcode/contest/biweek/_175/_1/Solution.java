package top.chenqwwq.leetcode.contest.biweek._175._1;

/**
 * @author chenqwwq
 * @date 2026/2/2
 **/
public class Solution {
    public String reverseByType(String s) {
        StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') s1.append(c);
            else s2.append(c);
        }

        StringBuilder ans = new StringBuilder();
        int l1 = s1.length(), l2 = s2.length();
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') ans.append(s1.charAt(--l1));
            else ans.append(s2.charAt(--l2));
        }
        return ans.toString();
    }
}