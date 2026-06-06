package top.chenqwwq.leetcode.contest.weekly._313._3;

/**
 * @author chenqwwq
 * @date 2022/10/10
 **/
public class Solution {
    int getCnt(int num) {
        int ans = 0;
        while (num != 0) {
            ans++;
            num &= (num - 1);
        }
        return ans;
    }

    public int minimizeXor(int num1, int num2) {
        int n = getCnt(num1), m = getCnt(num2);
        int ans = num1;
        if (n > m) {
            for (int i = 0; i < 32 && n > m; i++) {
                if ((ans & (1 << i)) != 0) {
                    ans ^= (1 << i);
                    n--;
                }
            }
            return ans;
        } else if (m > n) {
            for (int i = 0; i < 32 && m > n; i++) {
                if ((ans & (1 << i)) == 0) {
                    ans |= (1 << i);
                    m--;
                }
            }
        }
        return ans;
    }
}