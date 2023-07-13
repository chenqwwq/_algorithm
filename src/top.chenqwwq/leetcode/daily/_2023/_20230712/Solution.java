package top.chenqwwq.leetcode.daily._2023._20230712;

/**
 * @author 沽酒
 * @since 2023/07/12
 */
public class Solution {
    public int alternateDigitSum(int n) {
        String s = String.valueOf(n);
        final int m = s.length();
        int ans = 0, flag = 1;
        for (int i = 0; i < m; i++) {
            ans += (flag * (s.charAt(i) - '0'));
            flag *= -1;
        }
        return ans;
    }
}