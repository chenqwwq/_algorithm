package top.chenqwwq.leetcode.contest.weekly._422._1;

/**
 * @author chenqwwq
 * @date 2024/11/3
 **/
public class Solution {
    public boolean isBalanced(String num) {
        final int n = num.length();
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) a += num.charAt(i) - '0';
            else b += num.charAt(i) - '0';
        }
        return a == b;
    }
}