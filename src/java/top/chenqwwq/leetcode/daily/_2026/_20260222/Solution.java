package top.chenqwwq.leetcode.daily._2026._20260222;

/**
 * @author chenqwwq
 * @date 2026/2/22
 **/
public class Solution {
    public int binaryGap(int n) {
        if (Integer.bitCount(n) == 0) return 0;
        int pre = -1, ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                if (pre != -1) ans = Math.max(ans, i - pre);
                pre = i;
            }
        }
        return ans;
    }
}