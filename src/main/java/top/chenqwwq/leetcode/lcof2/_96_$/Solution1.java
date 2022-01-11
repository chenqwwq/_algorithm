package top.chenqwwq.leetcode.lcof2._96_$;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenbingxin
 * @date 2021/12/31
 **/
public class Solution1 {

    private static Map<Integer, Boolean> MEMO = new HashMap<>();


    public boolean isInterleave(String s1, String s2, String s3) {
        MEMO = new HashMap<>();
        if (s2.length() + s1.length() != s3.length()) {
            return false;
        }

        return dfs(s1, s2, s3, 0, 0, 0);
    }

    public boolean dfs(String s1, String s2, String s3, int i, int j, int k) {
        if (i >= s1.length() && j >= s2.length()) {
            return true;
        }
        final Integer key = getKey(i, j, k);
        if (MEMO.containsKey(key)) {
            return MEMO.get(key);
        }

        if (i < s1.length() && s3.charAt(k) == s1.charAt(i) && dfs(s1, s2, s3, i + 1, j, k + 1)) {
            MEMO.put(key, true);
            return true;
        }
        final boolean res = j < s2.length() && s3.charAt(k) == s2.charAt(j) && dfs(s1, s2, s3, i, j + 1, k + 1);
        MEMO.put(key, res);
        return res;
    }

    public Integer getKey(int i, int j, int k) {
        return i << 16 | j << 8 | k;
    }
}
