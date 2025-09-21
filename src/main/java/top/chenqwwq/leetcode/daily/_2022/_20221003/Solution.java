package top.chenqwwq.leetcode.daily._2022._20221003;

/**
 * @author chenqwwq
 * @date 2022/10/3
 **/
public class Solution {
    public boolean checkOnesSegment(String s) {
        final int n = s.length();
        boolean x = false, y = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (x) y = true;
            } else {
                if (y) return false;
                x = true;
            }
        }
        return true;
    }
}
