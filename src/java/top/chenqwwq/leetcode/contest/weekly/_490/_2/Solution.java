package top.chenqwwq.leetcode.contest.weekly._490._2;

/**
 * @author chenqwwq
 * @date 2026/2/22
 **/
public class Solution {

    static final int[] digits = new int[10];

    static {
        digits[0] = 1;
        for (int i = 1; i <= 9; i++) {
            digits[i] = digits[i - 1] * i;
        }
    }

    public boolean isDigitorialPermutation(int n) {
        int[] cs = new int[10];
        int t = n, total = 0;
        while (t != 0) {
            final int k = t % 10;
            total += digits[k];
            cs[k]++;
            t /= 10;
        }

        while (total != 0) {
            cs[total % 10]--;
            total /= 10;
        }

        for (int num : cs) {
            if (num != 0) return false;
        }
        return true;
    }
}