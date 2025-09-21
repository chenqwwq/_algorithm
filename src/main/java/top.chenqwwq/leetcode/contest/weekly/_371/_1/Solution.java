package top.chenqwwq.leetcode.contest.weekly._371._1;

/**
 * @author chenqwwq
 * @date 2023/11/12
 **/
public class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            for (int j : nums) {
                if (Math.abs(i - j) <= Math.min(i, j)) {
                    ans = Math.max(ans, i ^ j);
                }
            }
        }
        return ans;
    }
}