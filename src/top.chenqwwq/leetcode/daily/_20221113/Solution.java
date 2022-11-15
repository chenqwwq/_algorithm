package top.chenqwwq.leetcode.daily._20221113;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenqwwq
 * @date 2022/11/13
 **/
public class Solution {
    public String customSortString(String order, String s) {
        final int n = order.length(), m = s.length();
        int[] hash = new int[26];
        for (int i = 0; i < n; i++) hash[order.charAt(i) - 'a'] = i;
        Character[] cs = new Character[m];
        for (int i = 0; i < m; i++) cs[i] = s.charAt(i);
        Arrays.sort(cs, Comparator.comparingInt(o -> hash[o - 'a']));
        StringBuilder ans = new StringBuilder();
        for (char c : cs) ans.append(c);
        return ans.toString();
    }
}