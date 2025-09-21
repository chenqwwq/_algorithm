package top.chenqwwq.leetcode.contest.weekly._346._3;

/**
 * @author chenqwwq
 * @date 2023/5/22
 **/
public class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            final int num = i * i;
            if (check(Integer.toString(num), 0, i)) ans += num;
        }
        return ans;
    }

    private boolean check(String s, int l, int cur) {
        if (l >= s.length()) return cur == 0;
        int num = 0;
        for (; l < s.length(); l++) {
            num = num * 10 + s.charAt(l) - '0';
            if (check(s, l + 1, cur - num)) return true;
        }
        return false;
    }
}