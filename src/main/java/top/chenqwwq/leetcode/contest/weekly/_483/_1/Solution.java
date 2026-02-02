package top.chenqwwq.leetcode.contest.weekly._483._1;

/**
 * @author chenqwwq
 * @date 2026/1/5
 **/
public class Solution {
    public String largestEven(String s) {
        int n = s.length();
        while (n > 0 && s.charAt(n - 1) == '1') {
            n--;
        }
        return s.substring(0, n);
    }
}