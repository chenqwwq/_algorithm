package top.chenqwwq.leetcode.contest.weekly._396._396._3;

/**
 * @author chenqwwq
 * @date 2024/5/5
 **/
public class Solution {
    public int minAnagramLength(String s) {
        final int n = s.length();
        if (n % 2 != 0 && n % 3 != 0) {
            char c = s.charAt(0);
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != c) return n;
            }
            return 1;
        }

        return Math.min(handle(s, 2), handle(s, 3));
    }

    private int handle(String s, int k) {
        // TODO:
        return -1;
    }
}