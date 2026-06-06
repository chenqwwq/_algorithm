package top.chenqwwq.leetcode.contest.weekly._367._2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2023/10/15
 **/
public class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        final int n = s.length();
        List<String> ss = new ArrayList<>();
        int cnt = 0, l = 0, r = -1;
        while (++r < n) {
            cnt += s.charAt(r) - '0';
            while (cnt > k || (l < n  && s.charAt(l) == '0')) cnt -= s.charAt(l++) - '0';
            if (cnt == k) ss.add(s.substring(l, r + 1));
        }
        if (ss.isEmpty()) return "";
        ss.sort(Comparator.comparingInt(String::length).thenComparing(String::compareTo));
        return ss.get(0);
    }
}