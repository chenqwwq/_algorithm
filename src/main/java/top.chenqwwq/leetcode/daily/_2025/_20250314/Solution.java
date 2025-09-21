package top.chenqwwq.leetcode.daily._2025._20250314;

/**
 * @author chenqwwq
 * @date 2025/3/14
 **/
public class Solution {
    public boolean isBalanced(String num) {
        final int n = num.length();
        final char[] cs = num.toCharArray();
        long l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if((i & 1) == 1) l += cs[i] - '0';
            else r += cs[i] - '0';
        }
        return l == r;
    }
}