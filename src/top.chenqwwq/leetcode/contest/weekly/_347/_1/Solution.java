package top.chenqwwq.leetcode.contest.weekly._347._1;

/**
 * @author 沽酒
 * @since 2023/05/30
 */
public class Solution {
    public String removeTrailingZeros(String num) {
        final int n = num.length();
        StringBuilder ans = new StringBuilder();
        boolean flag = true;
        for (int i = n - 1; i >= 0; i--) {
            if (!flag || num.charAt(i) != '0') {
                ans.insert(0, num.charAt(i));
                flag = false;
            }
        }
        return ans.toString();
    }
}