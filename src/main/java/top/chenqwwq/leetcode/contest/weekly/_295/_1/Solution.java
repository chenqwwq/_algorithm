package top.chenqwwq.leetcode.contest.weekly._295._1;

/**
 * @author chenqwwq
 * @date 2022/5/29
 **/
public class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] h1 = new int[26], h2 = new int[26];
        for (char c : s.toCharArray()) {
            h1[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            h2[c - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (h2[i] != 0) {
                ans = Math.min(ans,h1[i] / h2[i]);
            }
        }
        return ans;
    }
}
