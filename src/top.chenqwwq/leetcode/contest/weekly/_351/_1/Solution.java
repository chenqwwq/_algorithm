package top.chenqwwq.leetcode.contest.weekly._351._1;

import java.util.Map;

/**
 * @author 沽酒
 * @since 2023/06/25
 */
public class Solution {

    boolean[][] gcd = new boolean[10][10];

    {
        for (int i = 1; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                gcd[i][j] = gcd[j][i] = gcd(i, j);
            }
        }
    }

    private boolean gcd(int a, int b) {
        if (a == 1) return true;
        if(a == b ) return false;
        for (int i = 2; i <= a; i++) {
            if (a % i == 0 && b % i == 0) return false;
        }
        return true;
    }

    public int countBeautifulPairs(int[] nums) {
        final int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gcd[String.valueOf(nums[i]).charAt(0)-'0'][nums[j] % 10]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}