package top.chenqwwq.leetcode.contest.weekly._314._3;

import java.util.concurrent.TimeUnit;

/**
 * @author chenqwwq
 * @date 2022/10/23
 **/
public class Solution {
    public String robotWithString(String s) {
        final int n = s.length();
        int[] hash = new int[26];
        for (char c : s.toCharArray()) hash[c - 'a']++;
        char[] stack = new char[n];
        int p = -1, min = 0;

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // 添加到栈中
            stack[++p] = s.charAt(i);
            hash[s.charAt(i)-'a']--;
            while (min < 25 && hash[min] == 0) min++;
            while (p >= 0 && stack[p] - 'a' <= min) ans.append(stack[p--]);
        }
        return ans.toString();
    }
}