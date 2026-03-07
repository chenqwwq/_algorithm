package top.chenqwwq.leetcode.contest.weekly._490._3;

/**
 * @author chenqwwq
 * @date 2026/2/22
 **/
public class Solution {
    public String maximumXor(String s, String t) {
        int[] cs = new int[2];
        for (char c : t.toCharArray()) {
            cs[c - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '0') {
                if (cs[1] > 0) {
                    sb.append('1');
                    cs[1]--;
                } else {
                    sb.append('0');
                    cs[0]--;
                }
            } else {
                if (cs[0] > 0) {
                    sb.append('1');
                    cs[0]--;
                } else {
                    sb.append('0');
                    cs[1]--;
                }
            }
        }
        return sb.toString();
    }
}