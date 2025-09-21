package top.chenqwwq.leetcode.contest.weekly._296._1;

/**
 * @author chenqwwq
 * @date 2022/6/5
 **/
public class Solution {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        int[][] ans = new int[2][n];
        System.arraycopy(nums, 0, ans[0], 0, n);
        int flag = 1, len = n;
        while (len > 1) {
            for (int i = 0; i < len >> 1; i++) {
                if ((i & 1) == 1) {
                    ans[flag][i] = Math.max(ans[flag^1][2 * i], ans[flag^1][2 * i + 1]);
                } else {
                    ans[flag][i] = Math.min(ans[flag^1][2 * i], ans[flag^1][2 * i + 1]);
                }
            }
            len >>= 1;
            flag ^= 1;
        }
        return ans[flag ^ 1][0];
    }

    public static void main(String[] args) {
        new Solution().minMaxGame(new int[]{70,38,21,22});
    }
}