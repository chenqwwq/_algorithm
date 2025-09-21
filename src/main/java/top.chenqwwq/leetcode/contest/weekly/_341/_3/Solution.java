package top.chenqwwq.leetcode.contest.weekly._341._3;

/**
 * @author chenqwwq
 * @date 2023/4/16
 **/
public class Solution {
    public int addMinimum(String word) {
        final int n = word.length();
        int ans = 0;
        word += "dd";
        for (int i = 0; i < n; ) {
            char c1 = word.charAt(i);
            char c2 = word.charAt(i + 1);
            char c3 = word.charAt(i + 2);
            if (c1 == 'a' && c2 == 'b' && c3 == 'c') {
                i += 3;
            } else if (c1 == 'b' && c2 == 'c') {
                ans++;
                i += 2;
            } else if (c1 == 'a' && c2 == 'b') {
                ans++;
                i += 2;
            } else if (c1 == 'a' && c2 == 'c') {
                ans++;
                i += 2;
            } else {
                ans += 2;
                i += 1;
            }
        }
        return ans;
    }
}