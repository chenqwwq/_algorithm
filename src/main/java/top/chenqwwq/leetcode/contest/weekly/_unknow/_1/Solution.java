package top.chenqwwq.leetcode.contest.weekly._unknow._1;

/**
 * @author chenqwwq
 * @date 2023/8/6
 **/
public class Solution {
    public String finalString(String s) {
        final int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            final char c = s.charAt(i);
            if(c != 'i') sb.append(c);
            else sb.reverse();
        }
        return sb.toString();
    }
}