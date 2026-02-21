package top.chenqwwq.leetcode.daily._2026._20260207;

/**
 * @author chenqwwq
 * @date 2026/2/7
 **/
public class Solution {
    public int minimumDeletions(String s) {
        final int n = s.length();
        int ca = 0, cb = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') ca++;
            else cb++;
        }

        int ans = Math.min(ca, cb);
        int c = 0;  // a 的数量
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') c++;
            int tvb = i + 1 - c;    // b 的数量
            ans = Math.min(ans, tvb + (ca - c));
        }

        return ans;
    }
}