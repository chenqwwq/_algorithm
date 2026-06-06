package top.chenqwwq.leetcode.contest.weekly._411._1;


/**
 * @author chenqwwq
 * @date 2024/8/20
 **/
public class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int ans = 0;
        int c0 = 0, c1 = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            if (s.charAt(r) == '0') c0++;
            else c1++;
            while (c0 > k && c1 > k) {
                if (s.charAt(l++) == '0') c0--;
                else c1--;
            }
            ans += (r - l + 1);
        }
        return ans;
    }
}