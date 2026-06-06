package top.chenqwwq.leetcode.daily._2025._20251226;

/**
 * @author chenqwwq
 * @date 2025/12/27
 **/
public class Solution {
    public int bestClosingTime(String customers) {
        final int n = customers.length();
        int cnt = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') cnt++;
        }

        int cur = 0;
        int cost = n - cnt, ans = n;
        for (int i = 0; i < n; i++) {
            int t = i - cur + cnt - cur;
            if (t < cost || (t == cost && i < ans)) {
                cost = t;
                ans = i;
            }
            if (customers.charAt(i) == 'Y') cur++;

        }
        return ans;
    }
}