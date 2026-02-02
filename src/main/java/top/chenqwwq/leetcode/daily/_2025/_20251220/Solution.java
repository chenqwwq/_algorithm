package top.chenqwwq.leetcode.daily._2025._20251220;

/**
 * @author chenqwwq
 * @date 2025/12/20
 **/
public class Solution {
    public int minDeletionSize(String[] strs) {
        final int n = strs.length, m = strs[0].length();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) <= strs[j - 1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}