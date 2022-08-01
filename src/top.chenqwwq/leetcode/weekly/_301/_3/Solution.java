package top.chenqwwq.leetcode.weekly._301._3;

/**
 * @author chenqwwq
 * @date 2022/7/10
 **/
public class Solution {
    public boolean canChange(String a, String b) {
        final int n = a.length();
        int x = 0, y = 0;
        int l1 = 0, r1 = -1;
        int l2 = 0, r2 = -1;

        while (x < n && y < n) {
            while (y < n && b.charAt(y) == '_') {
                y++;
            }
            if (y < n) {
                if (b.charAt(y) == 'L') {
                    l1 = y;
                } else if (r1 == -1) {
                    r1 = y;
                }
            }
            while (x < n && a.charAt(x) == '_') {
                x++;
            }
            if (x < n) {
                if (a.charAt(x) == 'L') {
                    l2 = x;
                } else if (r2 == -1) {
                    r2 = x;
                }
            }
            if (y < n && x < n && a.charAt(x) != b.charAt(y)) {
                return false;
            }
            x++;
            y++;
        }
        while (x < n) {
            if (a.charAt(x) != '_') {
                return false;
            }
            x++;
        }
        while (y < n) {
            if (b.charAt(y) != '_') {
                return false;
            }
            y++;
        }
        return x == y && l1 <= l2 && r1 >= r2;
    }
}