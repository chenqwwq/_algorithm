package top.chenqwwq.leetcode.daily._2024._20240824;

/**
 * @author chenqwwq
 * @date 2024/8/24
 **/
public class Solution {
    public int findPermutationDifference(String s, String t) {
        final int n = s.length();
        int ans = 0;
        int[] h1 = new int[26], h2 = new int[26];
        for (int i = 0; i < n; i++) {
            h1[s.charAt(i) - 'a'] = i;
            h2[t.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < 26; i++) {
           ans += Math.abs(h1[i] - h2[i]);
        }
        return ans;
    }
}