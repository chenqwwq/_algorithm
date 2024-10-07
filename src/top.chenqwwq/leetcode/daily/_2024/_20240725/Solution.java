package top.chenqwwq.leetcode.daily._2024._20240725;

/**
 * @author chenqwwq
 * @date 2024/7/25
 **/
public class Solution {
    public int minimumOperations(String num) {
        // 00 25 50 75
        final int n = num.length();
        int ans = n;
        int l5 = -1, l7 = -1, l2 = -1, l0 = -1;
        for (int i = 0; i < n; i++) {

            switch (num.charAt(i)) {
                case '0':
                    ans = Math.min(ans, n - 1);
                    if (l0 != -1) ans = Math.min(ans, n - l0 - 2);
                    if (l5 != -1) ans = Math.min(ans, n - l5 - 2);
                    l0 = i;
                    break;
                case '5':
                    if (l2 != -1) ans = Math.min(ans, n - l2 - 2);
                    if (l7 != -1) ans = Math.min(ans, n - l7 - 2);
                    l5 = i;
                    break;
                case '2':
                    l2 = i;
                    break;
                case '7':
                    l7 = i;
                    break;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}