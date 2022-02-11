package top.chenqwwq.leetcode.biweek._38._3;

/**
 * @author chen
 * @date 2020/10/31
 **/
public class Solution {
    public int countSubstrings(String s, String t) {
        int n = s.length(), m = t.length();
        int ans = 0;
        // 长度
        for (int l = 1; l <= n; l++) {
            // 起始地址
            for (int i = l; i < t.length(); i++) {
                int j = i + l;

            }
        }

        return ans;
    }
}