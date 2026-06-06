package top.chenqwwq.leetcode.contest.weekly._503._2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2026/5/24
 **/
public class Solution {
    final String C = "!@#$";

    public int passwordStrength(String password) {
        int ans = 0;
        int[] h1 = new int[26], h2 = new int[26], h3 = new int[10];
        Set<Character> sc = new HashSet<>();
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c) && ++h1[c - 'a'] == 1) ans++;
            else if (Character.isUpperCase(c) && ++h2[c - 'A'] == 1) ans += 2;
            else if (Character.isDigit(c) && ++h3[c - '0'] == 1) ans += 3;
            else if (C.indexOf(c) != -1 && !sc.contains(c)) {
                ans += 5;
                sc.add(c);
            }
        }
        return ans;
    }
}