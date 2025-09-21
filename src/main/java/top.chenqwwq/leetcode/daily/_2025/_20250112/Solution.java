package top.chenqwwq.leetcode.daily._2025._20250112;

/**
 * @author chenqwwq
 * @date 2025/1/13
 **/
public class Solution {
    public int largestCombination(int[] cs) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int c : cs) {
                if ((c & (1 << i)) != 0) {
                    cnt++;
                }
            }
            ans = Math.max(ans,cnt);
        }
        return ans;
    }
}