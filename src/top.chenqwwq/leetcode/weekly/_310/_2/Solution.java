package top.chenqwwq.leetcode.weekly._310._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/9/11
 **/
public class Solution {
    public int partitionString(String s) {
        final int n = s.length();
        int[] hash = new int[26];
        int cnt = 1;
        for (int i = 0, j = 0; i < n; i++) {
            char c = s.charAt(i);
            if (hash[c - 'a'] > 0) {
                cnt++;
                Arrays.fill(hash,0);
            }
            hash[c-'a']++;
        }
        return cnt;
    }
}