package top.chenqwwq.leetcode.weekly._239._2;

/**
 * @author chen
 * @date 2021/5/2
 **/
public class Solution {
    public boolean splitString(String s) {
        for (int i = 1; i < s.length(); i++) {
            final double curr = Double.parseDouble(s.substring(0, i));
            if (dfs(s, i, curr - 1)) {
                return true;
            }
        }
        return false;
    }

    boolean dfs(String s, int idx, double pre) {
        if (idx == s.length()) {
            return true;
        }
        if (pre < 0) {
            return false;
        }
        for (int i = idx + 1; i <= s.length(); i++) {
            final Double num = Double.parseDouble(s.substring(idx, i));
            if (num.equals(pre) && dfs(s, i, num - 1)) {
                return true;
            }
            if (num > pre) {
                break;
            }
        }
        return false;
    }
}
