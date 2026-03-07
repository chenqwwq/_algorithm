package top.chenqwwq.leetcode.contest.biweek._177._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/3/1
 **/
public class Solution {

    public String mergeCharacters(String s, int k) {
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            final int t = sb.charAt(i) - 'a';
            if (idx[t] != -1 && i - idx[t] < k) {
                sb.deleteCharAt(i);
                return mergeCharacters(sb.toString(), k);
            } else {
                idx[t] = i;
            }
        }
        return sb.toString();
    }
}