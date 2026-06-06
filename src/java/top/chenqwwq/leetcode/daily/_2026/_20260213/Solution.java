package top.chenqwwq.leetcode.daily._2026._20260213;

/**
 * @author chenqwwq
 * @date 2026/2/13
 **/
public class Solution {
    public int longestBalanced(String s) {
        final int n = s.length();
        int ans = 1;
        int[][] ps = new int[n + 1][3];

        for (int i = 0; i < n; i++) {
            System.arraycopy(ps[i], 0, ps[i + 1], 0, 3);
            ps[i + 1][s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                if (j - i <= ans) break;
                final int a = ps[j][0] - ps[i][0];
                final int b = ps[j][1] - ps[i][1];
                final int c = ps[j][2] - ps[i][2];
                if (check(a, b, c)) {
                    ans = Math.max(ans, j - i);
                    break;
                }
            }
        }
        return ans;
    }

    private boolean check(int... nums) {
        int cur = -1;
        for (int i = 0; i < 3; i++) {
            if (nums[i] == 0) continue;
            if (cur == -1) cur = nums[i];
            else if (cur != nums[i]) return false;
        }
        return true;
    }
}