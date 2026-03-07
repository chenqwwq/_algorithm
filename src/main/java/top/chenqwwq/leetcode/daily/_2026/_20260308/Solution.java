package top.chenqwwq.leetcode.daily._2026._20260308;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2026/3/8
 **/
public class Solution {
    Set<String> exist;
    int n;

    public String findDifferentBinaryString(String[] nums) {
        exist = new HashSet<>();
        n = nums.length;
        for (String num : nums) {
            for (int i = 1; i <= num.length(); i++) {
                exist.add(num.substring(0, i));
            }
        }
        return h("");
    }

    private String h(String s) {
        if (s.length() == n) {
            if (exist.contains(s)) return null;
            return s;
        }

        final String h1 = h(s + "0");
        if (h1 != null) return h1;
        return h(s + "1");
    }
}