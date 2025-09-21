package top.chenqwwq.leetcode.contest.biweek._145._1;

/**
 * @author chenqwwq
 * @date 2024/12/11
 **/
public class Solution {
    public int minOperations(int[] nums, int k) {
        final int[] hash = new int[101];
        int min = 101;
        for (int num : nums) {
            hash[num]++;
            min = Math.min(min, num);
        }

        if (min < k) return -1;
        int cnt = 0;
        for (int i = k + 1; i < 101; i++) {
            if (hash[i] > 0) cnt++;
        }
        return cnt;
    }
}