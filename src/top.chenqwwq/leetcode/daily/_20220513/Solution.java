package top.chenqwwq.leetcode.daily._20220513;

/**
 * @author chenqwwq
 * @date 2022/5/13
 **/
public class Solution {
    public boolean oneEditAway(String first, String second) {
        final int n = first.length(), m = second.length();
        if (Math.abs(n - m) > 1) {
            return false;
        }
        boolean flag = true;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
                continue;
            }
            if (!flag) {
                return false;
            }

            if (n > m) {
                i++;
            } else if (n < m) {
                j++;
            } else {
                i++;
                j++;
            }
            flag = false;
        }
        return true;
    }
}
