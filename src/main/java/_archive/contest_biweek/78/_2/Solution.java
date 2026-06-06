package top.chenqwwq.leetcode.contest.biweek._78._2;

/**
 * @author chenqwwq
 * @date 2022/5/14
 **/
public class Solution {
    public int waysToSplitArray(int[] nums) {
        final int n = nums.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = nums[i] + ps[i];
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if(ps[i] - ps[0] >= ps[n] - ps[i]){
                ans++;
            }
        }
        return ans;
    }
}