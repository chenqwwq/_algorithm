package top.chenqwwq.leetcode.contest.biweek._147._1;

import java.util.Objects;

/**
 * @author chenqwwq
 * @date 2025/1/4
 **/
public class Solution {
    public boolean hasMatch(String s, String p) {
        if(Objects.equals(p, "*")) return true;
        final String[] ws = p.split("\\*");
        if(ws.length == 1){
            return s.contains(ws[0]);
        }
        final int i = s.indexOf(ws[0]);
        final int j = s.lastIndexOf(ws[1]);
        return i!=-1 && j != -1 && i + ws[0].length() <= j;
    }

    public static void main(String[] args) {
        new Solution().hasMatch("leetcode", "ee*e");
    }
}