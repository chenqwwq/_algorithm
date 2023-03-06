package top.chenqwwq.leetcode.daily._2022._20220424;

/**
 * @author chenqwwq
 * @date 2022/4/24
 **/
public class Solution {
    public int binaryGap(int n) {
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        for (int l = -1, r = 0; r < 31; r++) {
            if ((n >> r & 1) == 1) {
                if (l != -1) {
                    ans = Math.max(ans, r - l);
                }
                    l = r;
            }
        }
        return ans;
    }
}