package top.chenqwwq.leetcode.daily._2025._20250107;

/**
 * @author chenqwwq
 * @date 2025/1/7
 **/
public class Solution {
    public int countKeyChanges(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int ans = 0;
        s = s.toLowerCase();
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            final char cc = s.charAt(i);
            if (cc != c) {
                c = cc;
                ans++;
            }
        }
        return ans;
    }
}