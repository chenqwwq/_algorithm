package top.chenqwwq.leetcode.weekly._293._3;

/**
 * @author chenqwwq
 * @date 2022/5/15
 **/
public class Solution {
    public int largestCombination(int[] candidates) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int tmp = 0;
            for (int num : candidates) {
                if ((num >> i & 1) == 1) {
                    tmp++;
                }
            }
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}