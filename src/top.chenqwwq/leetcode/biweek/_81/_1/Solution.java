package top.chenqwwq.leetcode.biweek._81._1;

/**
 * @author chenqwwq
 * @date 2022/6/26
 **/
public class Solution {
    public int countAsterisks(String s) {
        final int n = s.length();
        boolean flag = true;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            final char c = s.charAt(i);
            if (c == '|') {
                flag = !flag;
            } else if (c == '*' && flag) {
                ans++;
            }
        }
        return ans;
    }
}